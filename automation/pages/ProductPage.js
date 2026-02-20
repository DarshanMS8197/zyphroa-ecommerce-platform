// // class ProductPage {
// //   constructor(page) {
// //     this.page = page;
// //     this.addToCartBtn = 'button:has-text("Add to Cart")';
// //     this.toast = '#toast';
// //   }

// //   async addToCart() {
// //     await this.page.click(this.addToCartBtn);
// //   }
// // }

// // module.exports = ProductPage;

// class ProductPage {
//   constructor(page) {
//     this.page = page;
//     this.addToCartBtn = 'button:has-text("Add to Cart")';
//     this.backBtn = 'a.btn-secondary';
//     this.productTitle = '.product-detail h1';
//     this.productPrice = '.product-detail .price';
//     this.quantityInput = 'input[type="number"]';
//   }

//   async addToCart() {
//     await this.page.waitForSelector(this.addToCartBtn, { state: 'visible', timeout: 10000 });
//     await this.page.click(this.addToCartBtn);
//     await this.page.waitForSelector('.toast', { timeout: 5000 });
//   }

//   async changeQuantity(value) {
//     await this.page.fill(this.quantityInput, value.toString());
//   }

//   async backToHome() {
//     await this.page.click(this.backBtn);
//     await this.page.waitForURL('/home.html');
//   }
// }

// module.exports = ProductPage;
class ProductPage {
  constructor(page) {
    this.page = page;
    // Selectors matching product.js rendering
    this.addToCartBtn = page.locator('#add-to-cart');
    this.backBtn = page.locator('a.btn-secondary');
    this.productTitle = page.locator('.product-detail-info h1');
    this.productPrice = page.locator('.product-detail-price');
    this.toast = page.locator('#toast');
  }

  async addToCart() {
    await this.addToCartBtn.waitFor({ state: 'visible' });
    await this.addToCartBtn.click();
    // Wait for the toast notification
    await this.toast.waitFor({ state: 'visible', timeout: 5000 });
  }

  async backToHome() {
    await this.backBtn.click();
  }
}

module.exports = ProductPage;
