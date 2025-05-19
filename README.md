# Pi-Shop

Welcome to **pi-shop**!

This project aims to set up a **virtual cash register** for children to play with.

They can add items to a checkout to emulate a transaction in a supermarket, or they can collect items for delivery! 

## Concept

The idea is to use a physical barcode scanner to scan items.

This barcode scanner would need to be connected to an **application** (e.g. running on a Raspberry Pi).

This application would also provide a **user interface** (either through an external screen, but preferably as a web application so that it can be accessed through a device with touchscreen [phone, tablet])

### Checkout

The checkout would start with an empty list. Scanning items adds them to the checkout.

In the future, the calculation of a total price in some form of currency could be implemented.

### Deliveries

The deliveries could be a way to encourage playing independently. Instead of randomly scanning items, deliveries could require certain items to be scanned.

Multiple deliveries could make sure that no items appear on the same delivery.

## Management

Users with an admin role (parents) should be able to manage adding or removing items.
Adding new items would mean creating a physical barcode that can be linked to an item in the **pi-shop**.


# Resources

### Uploading an image
https://www.javainuse.com/fullstack/imageupload

### Angular Observable
https://www.angularjswiki.com/httpclient/observable/

### Using HttpClient
https://angular.dev/guide/http/making-requests

### Websockets
- https://www.stackextend.com/angular/websocket-with-spring-boot-and-angular/
  - `npm install --save sockjs-client stompjs`
- https://stackoverflow.com/questions/43104114/cannot-find-name-require-after-upgrading-to-angular4
  - `npm install --save-dev @types/node`
- https://stackoverflow.com/questions/54275069/module-not-found-error-cant-resolve-net-in-node-modules-stompjs-lib
  - `npm install net -S`
- https://stackoverflow.com/questions/74579858/uncaught-referenceerror-global-is-not-defined-in-angular