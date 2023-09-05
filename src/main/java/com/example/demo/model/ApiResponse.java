package com.example.demo.model;

public class ApiResponse {
    private String status;  // Status yang akan ditampilkan dalam bentuk JSON
    private String message;   // Pesan yang akan ditampilkan dalam bentuk JSON

    public ApiResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
