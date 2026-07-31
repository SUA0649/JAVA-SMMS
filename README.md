# SMMS Backend: Architecture & Linux Command Guide

This document serves as the master blueprint for the Social Media Management System (SMMS) backend infrastructure. It details the production architecture, the zero-downtime deployment flow, and a comprehensive glossary of the Linux commands used to manage the server.
---

## 1. Architecture Overview

Our backend is built utilizing a **Zero-Downtime Blue-Green Deployment** strategy on a single AWS EC2 Ubuntu instance. 

### The Tech Stack
* **Framework:** Java 26 / Spring Boot 4.1
* **Build Tool:** Maven 
* **Database:** MySQL
* **Web Server / Reverse Proxy:** NGINX
* **Process Manager:** `systemd`
* **CI/CD:** GitHub Actions

### The Blue-Green Flow
Instead of turning off the live server to deploy an update (which causes 502/500 errors), we run two parallel services:
1. **smms-blue (Port 8080)**
2. **smms-green (Port 8081)**

When a deployment is triggered, GitHub Actions uploads the new `.jar` file to the server. Our custom deployment script (`deploy-backend.sh`) wakes up the inactive color, waits for Spring Boot to pass its `/actuator/health` check, dynamically updates NGINX to point to the new port, and gracefully shuts down the old version. **Users experience zero seconds of downtime.**

### The Directory Structure
All backend artifacts live in a single, unified master directory to prevent path-mismatch errors:
* **Master Path:** `/home/ubuntu/smms/`
* **Incoming Staging File:** `target-new.jar`
* **Live Executables:** `smms-blue.jar` & `smms-green.jar`
* **Deployment Script:** `/home/ubuntu/deploy-backend.sh`

---

## 2. Linux Command Master Glossary

Transitioning from a local Windows/Mac environment to a headless Linux server requires a specific set of commands. Here are the exact commands used to build, manage, and debug this infrastructure.

### A. Process Management (`systemd`)
`systemd` is the master process manager in Ubuntu. We use it to turn our Java application into a resilient background daemon that automatically restarts on crashes.

* `sudo systemctl start smms-blue`  
  *Starts the service in the background.*
* `sudo systemctl stop smms-blue`  
  *Gracefully kills the running Java application.*
* `sudo systemctl restart smms-blue`  
  *Stops and instantly restarts the service.*
* `sudo systemctl enable smms-blue`  
  *Tells Ubuntu to automatically start this service if the physical EC2 server reboots.*
* `sudo systemctl disable smms`  
  *Removes a service from the startup sequence (used when decommissioning our legacy setup).*
* `sudo systemctl daemon-reload`  
  ***Crucial:** Must be run every time you edit or delete a `.service` file so Ubuntu recognizes the changes.*
* `sudo systemctl status smms-blue`  
  *Shows whether the app is active, failed, or booting, along with the most recent few lines of logs.*

### B. NGINX Management
NGINX is our reverse proxy, sitting on Port 80/443, routing traffic to our internal Java ports.

* `sudo nginx -t`  
  *The safety check. Analyzes your NGINX configuration files for missing semicolons or syntax errors without affecting live traffic.*
* `sudo systemctl reload nginx`  
  *Applies configuration changes instantly **without dropping active user connections**. (This is the magic command used in our Blue-Green script).*
* `sudo systemctl restart nginx`  
  *A hard reset of NGINX. Drops active connections. Only use if `reload` fails.*

### C. File & System Operations
* `sudo nano /etc/nginx/sites-available/smms`  
