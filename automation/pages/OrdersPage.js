
// class OrdersPage {
//   constructor(page) {
//     this.page = page;
//     this.ordersList = '#orders-list';
//   }

//   async goto() {
//     await this.page.goto('http://127.0.0.1:5500/website/orders.html');
//   }
// }

// module.exports = OrdersPage;

class OrdersPage {
  constructor(page) {
    this.page = page;
    this.ordersList = page.locator('#orders-list');
    this.emptyState = page.locator('#orders-empty');
  }

  async goto() {
    // IMPORTANT: Use relative path. 
    // Playwright will combine this with baseURL from config.
    await this.page.goto('/orders.html');
  }
}
module.exports = OrdersPage;

