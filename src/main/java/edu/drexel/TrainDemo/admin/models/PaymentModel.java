package edu.drexel.TrainDemo.admin.models;


public class PaymentModel {
    private String vendorName;

    public PaymentModel(String name) {
			vendorName = name;
    }

    public String getName() {
        return vendorName;
    }
}
