package com.Shaheer.smms.Dto;

import java.time.LocalDateTime;

public class EquipmentTrackingUpdateDTO {
    private LocalDateTime date_returned;

    public LocalDateTime getDate_returned() {
        return date_returned;
    }

    public void setDate_returned(LocalDateTime date_returned) {
        this.date_returned = date_returned;
    }
}
