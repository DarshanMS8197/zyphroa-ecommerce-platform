// class AuthPage {
//   constructor(page) {
//     this.page = page;
//     this.emailInput = '#email';
//     this.passwordInput = '#password';
//     this.loginButton = 'button[type="submit"]';
//   }

//   async goto() {
//     await this.page.goto('http://127.0.0.1:5500/website/index.html');
//   }

//   async login(email, password) {
//     await this.page.fill(this.emailInput, email);
//     await this.page.fill(this.passwordInput, password);
//     await this.page.click(this.loginButton);
//   }
// }

// module.exports = AuthPage;
// class AuthPage {
//   constructor(page) {
//     this.page = page;
//     this.loginEmail = '#login-email';
//     this.loginPassword = '#login-password';
//     this.loginBtn = '#login-form button[type="submit"]';
//     this.signupEmail = '#signup-email';
//     this.signupPassword = '#signup-password';
//     this.signupBtn = '#signup-form button[type="submit"]';
//   }
//   async login(email, password) {
//     await this.page.fill(this.loginEmail, email);
//     await this.page.fill(this.loginPassword, password);
//     await this.page.click(this.loginBtn);
//     await this.page.waitForURL('http://127.0.0.1:5500/website/home.html', { timeout: 10000 });
//   }
//   async signup(email, password) {
//     await this.page.click('button[data-tab="signup"]');
//     await this.page.fill(this.signupEmail, email);
//     await this.page.fill(this.signupPassword, password);
//     await this.page.click(this.signupBtn);
//   }
// }
// module.exports = AuthPage;

class AuthPage {
  constructor(page) {
    this.page = page;
  }

  async login(email, password) {
    await this.page.fill('#login-email', email);
    await this.page.fill('#login-password', password);
    await this.page.click('#login-form button[type="submit"]');
  }

  async signup(email, password) {
    await this.page.fill('#signup-email', email);
    await this.page.fill('#signup-password', password);
    await this.page.click('#signup-form button[type="submit"]');
  }
}
module.exports = AuthPage;