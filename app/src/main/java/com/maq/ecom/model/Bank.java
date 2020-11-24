package com.maq.ecom.model;

public class Bank {

    private String bankId, bankName, bankImage;
    boolean  isChecked;

    public Bank(String bankId, String bankName, String bankImage) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.bankImage = bankImage;
    }

    public String getBankId() {
        return bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankImage() {
        return bankImage;
    }


    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
