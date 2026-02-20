// // const { defineConfig, devices } = require('@playwright/test');

// // module.exports = defineConfig({
// //   testDir: './tests',
// //   fullyParallel: true,
// //   /* Set timeout to handle local loading */
// //   timeout: 30000,
// //   use: {
// //     /* THIS IS THE FIX: Base URL must match your Live Server exactly */
// //     baseURL: 'http://127.0.0.1:5500/website',
// //     trace: 'on-first-retry',
// //     screenshot: 'only-on-failure',
// //   },
// //   /* Automatically starts your site before testing */
// //   webServer: {
// //     command: 'npx serve .. -p 5500', 
// //     url: 'http://127.0.0.1:5500/website',
// //     reuseExistingServer: true,
// //   },
// //   projects: [
// //     { name: 'chromium', use: { ...devices['Desktop Chrome'] } },
// //   ],
// // });


// const { defineConfig, devices } = require('@playwright/test');

// module.exports = defineConfig({
//   testDir: './tests',
//   fullyParallel: true,
//   /* Set timeout to handle local loading */
//   timeout: 30000,

//   /* 1️⃣ ADD REPORTERS HERE */
//   reporter: [
//     ['html'],                                      // Standard Playwright HTML report
//     ['allure-playwright', { resultsDir: 'allure-results' }] // Raw data for Allure
//   ],

//   use: {
//     /* Base URL matches your Live Server */
//     baseURL: 'http://127.0.0.1:5500/website',
    
//     /* 2️⃣ AUTOMATIC LOGIN: This uses the session saved by your setup file */
//     storageState: 'storageState.json',

//     trace: 'on-first-retry',
//     screenshot: 'only-on-failure',
//     video: 'retain-on-failure', // Added video for better debugging in reports
//   },

//   /* Automatically starts your site before testing */
//   webServer: {
//     command: 'npx serve .. -p 5500', 
//     url: 'http://127.0.0.1:5500/website',
//     reuseExistingServer: true,
//   },

//   projects: [
//     { name: 'chromium', use: { ...devices['Desktop Chrome'] } },
//   ],
// });




const { defineConfig, devices } = require('@playwright/test');
const fs = require('fs');
const path = require('path');

// Check if storage state exists to avoid crashing tests if login setup hasn't run
const authStatePath = path.join(__dirname, 'storageState.json');
const storageState = fs.existsSync(authStatePath) ? authStatePath : undefined;

module.exports = defineConfig({
  testDir: './tests',
  fullyParallel: true,
  timeout: 30000,

  /* 1️⃣ UPDATED REPORTERS */
  reporter: [
    ['html', { open: 'on-failure' }], // Opens the report only if something fails
    ['allure-playwright', { resultsDir: 'allure-results' }]
  ],

  use: {
    baseURL: 'http://127.0.0.1:5500/website',
    
    /* 2️⃣ DYNAMIC AUTH: Only uses the session if it exists */
    storageState: storageState, //

    trace: 'on-first-retry',
    screenshot: 'only-on-failure',
    video: 'retain-on-failure', //
  },

  /* Automatically starts your site before testing */
  webServer: {
    command: 'npx serve .. -p 5500', 
    url: 'http://127.0.0.1:5500/website',
    reuseExistingServer: true, //
  },

  projects: [
    { name: 'chromium', use: { ...devices['Desktop Chrome'] } },
  ],
});