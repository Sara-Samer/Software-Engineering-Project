class PremiumUser extends User{
    PaymentAccount account;
    void updatePaymentAccount(PaymentAccount account){}
    Ad createAd(String header, String[] headlines, String[] description){ return new Ad();}
}
