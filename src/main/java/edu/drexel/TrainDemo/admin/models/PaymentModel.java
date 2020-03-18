package edu.drexel.TrainDemo.admin.models;


public class PaymentModel {
    private String name;

    public PaymentModel(String name) {
			this.name = name;
    }

    public String getName() {
        return name;
    }

		public void setName(String name) {
			this.name = name;
		}			
}
