export class Transaction {
    constructor(
        public transactionId: number,
        public merchantId:number,
        public customerName:string,
        public cartId:number,
        public purchasedAt:Date,
        public billingAddress:string,
        public totalAmount:number,
        public paymentReceived:Date,
        public pincode:number
    ){}
}
