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



