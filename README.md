# Zyphroa – E-commerce Website

A complete front-end e-commerce site built with **HTML**, **CSS**, and **Vanilla JavaScript**. No backend or frameworks; all data is stored in **Local Storage**.

## Features

- **Login / Sign up** – Email & password, stored in Local Storage; redirects to Home when authenticated.
- **Home** – Product grid (electronics, home appliances, accessories), search bar, sticky nav (Home, Cart, Orders, Logout).
- **Product page** – Image, title, price, description, genre, rating; **Add to Cart** (quantity handled, no duplicates).
- **Cart** – List with image, name, price, quantity, subtotal; increase/decrease, remove; grand total; **Checkout**.
- **Checkout** – Order summary and shipping details; **Proceed to Payment**.
- **Payment** – Card name, number, expiry, CVV, billing address; on success: order saved, cart cleared, redirect to Orders.
- **Orders** – Order history with Order ID, items, total, date; persisted in Local Storage.

## How to run

1. Open the project folder and serve it over HTTP (required for some browser features).
   - **VS Code**: Install “Live Server” and right-click `index.html` → “Open with Live Server”.
   - **Node**: `npx serve .` from the project root.
   - Or open `index.html` directly in the browser (some features may vary).
2. Start at `index.html` – sign up or log in, then use Home, Cart, Checkout, Payment, and Orders.

## Tech stack

- HTML5, CSS3 (custom properties, grid, flexbox)
- Vanilla JS (no frameworks)
- Local Storage for users, cart, and orders

## Performance

- Scripts use `defer`.
- Images use `width`/`height`, `loading="lazy"` (first product image `eager` + `fetchpriority="high"`).
- Preconnect to image CDN on image-heavy pages.
- Single CSS file, minimal DOM.

Test with Chrome DevTools → Lighthouse (Performance, Accessibility, Best Practices, SEO) for optimal scores.



## 🚀 COMPLETE FLOW (From Beginning)
🔹 STEP 1 — Open Project Folder

## Open terminal inside your project:

cd C:\Users\Administrator\Downloads\zyphroa
🔹 STEP 2 — Clean Old Build & Old Allure Results

## ⚠️ VERY IMPORTANT (to avoid old test cases in report)

mvn clean

## This deletes:

-target folder

-old allure-results

-old reports

## 🔹 STEP 3 — Run All Test Cases

##  To run all tests:

mvn test



OR



## To run only one test class:

mvn test -Dtest=LoginTest

OR

## Run multiple classes:

mvn test -Dtest=LoginTest,CartTest

## After this step:
## ✔ New results will be generated inside:

target/allure-results

## 🔹 STEP 4 — Generate & Open Allure Report (Temporary Server)

## Now run:

allure serve target/allure-results

## This will:

-Generate report

-Start local server

-Automatically open browser
