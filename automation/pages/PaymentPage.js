
// class PaymentPage {
//   constructor(page) {
//     this.page = page;
//     this.name = '#card-name';
//     this.number = '#card-number';
//     this.expiry = '#card-expiry';
//     this.cvv = '#card-cvv';
//     this.payBtn = 'button[type="submit"]';
//   }

//   async pay(card) {
//     await this.page.fill(this.name, card.name);
//     await this.page.fill(this.number, card.number);
//     await this.page.fill(this.expiry, card.expiry);
//     await this.page.fill(this.cvv, card.cvv);
//     await this.page.click(this.payBtn);
//   }
// }

// module.exports = PaymentPage;
class PaymentPage {
  constructor(page) {
    this.page = page;
    this.name = '#card-name';
    this.number = '#card-number';
    this.expiry = '#card-expiry';
    this.cvv = '#card-cvv';
    this.billing = '#card-billing';
    this.payBtn = 'button[type="submit"]';
    this.successMsg = '#payment-success';
  }

  async pay(card) {
    await this.page.fill(this.name, card.name);
    await this.page.fill(this.number, card.number);
    await this.page.fill(this.expiry, card.expiry);
    await this.page.fill(this.cvv, card.cvv);
    await this.page.fill(this.billing, card.billing || 'Same as shipping');
    await this.page.click(this.payBtn);
    await this.page.waitForSelector(this.successMsg, { timeout: 10000 });
  }
}

module.exports = PaymentPage;

