class PaymentAccount {
    private String creditCardNumber;
    private String holderName;
    public PaymentAccount(String creditCardNumber, String holderName) {
    	this.creditCardNumber = creditCardNumber;
    	this.holderName = holderName;
    }
    public String getCreditCardNumber(){return this.creditCardNumber;}
    public String getHolderName() {return this.holderName;}
}
