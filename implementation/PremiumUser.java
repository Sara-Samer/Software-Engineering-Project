class PremiumUser extends User{
    private PaymentAccount account;
    private Ad[] ads;
    
    void updatePaymentAccount(PaymentAccount account){}
    Ad createAd(String header, String[] headlines, String[] description){ return new Ad();}
    PremiumUser(User user){
    	super(user);
    }
    PremiumUser(User user, PaymentAccount account){
        super(user);
        this.account = account;
    }
    public void setPaymentAccount(PaymentAccount account) {
    	this.account = account;
    }
    public PaymentAccount getPaymentAccount(){
    	return account;
    }
}
