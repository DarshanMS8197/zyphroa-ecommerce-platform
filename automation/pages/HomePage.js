
// class HomePage {
//   constructor(page) {
//     this.page = page;
//     this.searchInput = 'input[type="search"], input[type="text"]';
//   }

//   async searchProduct(name) {
//     await this.page.fill(this.searchInput, name);
//     await this.page.keyboard.press('Enter');
//   }
// }

// module.exports = HomePage;
class HomePage {
  constructor(page) {
    this.page = page;
    this.searchInput = 'input[type="search"], input[type="text"]';
    this.productsGrid = '#products-grid';
    this.clearSearchBtn = '#clear-search';
    this.productCard = '.product-card';
    this.cartIcon = '#main-nav .cart-icon';
  }

  async searchProduct(name) {
    await this.page.waitForSelector(this.searchInput, { state: 'visible', timeout: 10000 });
    await this.page.fill(this.searchInput, name);
    await this.page.keyboard.press('Enter');
  }

  async clearSearch() {
    await this.page.click(this.clearSearchBtn);
  }

  async openProduct(index = 0) {
    await this.page.click(`${this.productCard}:nth-child(${index + 1})`);
  }
}

module.exports = HomePage;

