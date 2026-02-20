class CheckoutPage {
  constructor(page) {
    this.page = page;
    // These MUST match the IDs in your checkout.html/js
    this.name = '#ship-name';
    this.address = '#ship-address';
    this.phone = '#ship-phone';
    this.email = '#ship-email';
    this.submitBtn = 'button[type="submit"]';
  }

  async fillDetails({ name = '', email = '', address = '', phone = '' }) {
    if (name !== undefined) await this.page.fill(this.name, name);
    if (address !== undefined) await this.page.fill(this.address, address);
    if (phone !== undefined) await this.page.fill(this.phone, phone);
    // Note: ship-email is readonly in your JS, so we usually don't fill it here
  }

  async continueToPayment() {
    await this.page.click(this.submitBtn);
  }
}

module.exports = CheckoutPage;