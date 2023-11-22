package com.example.groupnameapi.model;

import java.util.Date;

public class cancelledResmodel {

    private int id;
    private int ticketNo;

    private boolean refund;

    private Date processedBy;

    private Date cancellationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public boolean isRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }

    public Date getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(Date processedBy) {
        this.processedBy = processedBy;
    }

    public Date getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(Date cancellationDate) {
        this.cancellationDate = cancellationDate;
    }
}
