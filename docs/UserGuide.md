---
layout: page
title: User Guide
---

# Overview

Introducing **Trackr - the ultimate desktop application** designed to simplify the delivery management process for your home business!

With Trackr, you can seamlessly manage your suppliers, orders and tasks.

It utilizes a Command Line Interface (CLI), while still enjoying the benefits of a user-friendly Graphical User Interface (GUI).

Say goodbye to the hassle of Excel and the stress of time constraints! Whether you're a busy home business owner or simply looking for an efficient and streamlined solution, Trackr is the perfect fit for you.
Experience the convenience of delivery management like never before with Trackr.

# About This Guide

This guide shows you the relevant information for setting up and using Trackr to manage your suppliers, orders and tasks.

You can click on any of the links below to navigate to the respective sections for more information.


# Table of Contents

<!-- TOC -->
* [Quick start](#quick-start)
  * [Prerequisites](#prerequisites)
    * [Java](#java)
    * [Glossary](#glossary)
  * [Installation](#installation)
* [Features](#features)
    * [Viewing help: `help`](#viewing-help-help)
  * [Add](#add)
    * [Adding a supplier: `add_supplier` or `add_s`](#adding-a-supplier-addsupplier-or-adds)
    * [Adding an order: `add_order` or `add_o`](#adding-an-order-addorder-or-addo)
    * [Adding a task: `add_task` or `add_t`](#adding-a-task-addtask-or-addt)
    * [Adding a menu item: `add_item` / `add_i`](#adding-a-menu-item-additem--addi)
  * [Edit](#edit)
    * [Editing a supplier: `edit_supplier` or `edit_s`](#editing-a-supplier-editsupplier-or-edits)
    * [Editing an order: `edit_order` or `edit_o`](#editing-an-order-editorder-or-edito)
    * [Editing a task: `edit_task` or `edit_t`](#editing-a-task-edittask-or-editt)
    * [Editing a menu item : `edit_item` / `edit_i`](#editing-a-menu-item--edititem--editi)
  * [Find](#find)
    * [Finding a supplier: `find_supplier` or `find_s`](#finding-a-supplier-findsupplier-or-finds)
    * [Finding a task: `find_task` or `find_t`](#finding-a-task-findtask-or-findt)
    * [Finding a menu item : `find_item` / `find_i`](#finding-a-menu-item--finditem--findi)
  * [Delete](#delete)
    * [Deleting a supplier: `delete_supplier` or `delete_s`](#deleting-a-supplier-deletesupplier-or-deletes)
    * [Deleting an order: `delete_order` or `delete_o`](#deleting-an-order-deleteorder-or-deleteo)
    * [Deleting a task: `delete_task` or `delete_t`](#deleting-a-task-deletetask-or-deletet)
    * [Deleting a menu item: `delete_item` / `delete_i`](#deleting-a-menu-item-deleteitem--deletei)
  * [Switch](#switch)
    * [Sorting a task: `sort_task` / `sort_t`](#sorting-a-task-sorttask--sortt)
    * [Switching tabs: `tab`](#switching-tabs-tab)
  * [Others](#others)
    * [Exiting the program: `exit`](#exiting-the-program-exit)
    * [Saving the data](#saving-the-data)
    * [Editing the data file](#editing-the-data-file)
    * [Uploading a csv file](#uploading-a-csv-file)
    * [Upcoming features `[coming soon]`](#upcoming-features-coming-soon)
* [FAQ](#faq)
* [Command summary](#command-summary)
<!-- TOC -->

--------------------------------------------------------------------------------------------------------------------
<div style="page-break-after: always;"></div>

# Quick start

## Prerequisites

### Java
Ensure you have <ins>[Java `11`](https://www.oracle.com/sg/java/technologies/javase/jdk11-archive-downloads.html)</ins> or above installed.

<div markdown="block" class="alert alert-tip">

  :bulb: **How to check your current Java version:**<br>
  1. Open up **Command Prompt** (Windows) or **Terminal** (Mac and Linux).
  1. Type and run the command `java -version`. 
  1. Check the version number provided (`xxx`) is at least `11`.

  An example is shown below.

  ```
  > java -version
  java version "xxx" <Other information>
  ```

</div>

### Glossary

* **Mainstream OS**: Windows, Linux, Unix, OS-X
* **CLI**: Command-Line Interface
* **GUI**: Graphical User Interface
* **Supplier**: Supplier refers to someone whom the user seasonally or frequently orders goods from
* **Customer**: Customer refers to someone whom the user receives an order from
* **Order**: Order refers to the customers' orders the user accepts
* **Task**: Task refers to any to-dos the user may have, it need not be related to suppliers or orders (For instance, it can be about tidying inventory)
* **Menu Item**: Menu Item refers to any inventory/ stock that the user is selling to customers.
* **Tag**: Tags are associated with suppliers, users can tag the supplier with any keyword they want, number of tags are not restricted
* **Status**: Statuses are associated with tasks and orders, one entry of task/order can only have one status and the type of status that can be added is restricted

## Installation

1. Download the latest `trackr.jar` from [here](https://github.com/AY2223S2-CS2103T-W15-2/tp/releases).
1. Copy the file to the folder where you will use Trackr.
1. Double-click on the `trackr.jar` file.

  <div markdown="block" class="alert alert-tip">
    :bulb: **Trackr does not open?**<br>
    1. Open a command terminal.
    1. Type in `java -jar ` (Keep in mind of the space at the end).
    1. Drag and drop `trackr.jar` into the command terminal.
    1. Press enter and execute the command.
  
    An example of the final command is displayed below.
    ```
    > java -jar xxxx/xxxx/trackr.jar
    ```
  </div>

  A GUI similar to the below should appear in a few seconds. (Note how the app contains some sample data.) <br>
  
  <p align="center">
      <img src="images/Ui.png" />
      <br>Figure 1: Initial Setup UI
  </p>

1. Type your command in the command box and press Enter to execute it. (e.g. typing **`help`** and pressing Enter will open the help window.) <br>
   
   Some example commands you can try:

   * `add_order n/John Doe l/John Street d/2023-12-12 q/10 f/Cupcakes p/91234567` : Adds an order for John Doe to the order list.

   * `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

# Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Command keywords are case-sensitive, all command keywords must be in lower-case.
  e.g. For add supplier command, `add_supplier` is valid but `ADD_SUPPLIER` and `Add_Supplier` are not.

* Words in `UPPER_CASE` are the parameters to be supplied by you.<br>
  e.g. in `add_supplier n/NAME`, `NAME` is a parameter which can be used as `add_supplier n/John Doe`.

* Prefixes of the parameters are case-sensitive.<br>
  e.g. `n/` in `add_s n/NAME` is case-sensitive (i.e. `N/` is an invalid prefix).

* Items in square brackets are optional.<br>
  e.g. `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items in curly brackets need to have at least 1 item supplied.
  e.g. `{p/PHONE_NUMBER e/EMAIL}` can be used as `p/91234567` or `e/john@example.com` but cannot be left blank.

* Items with `…​` after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (omitted), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command, but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help: `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Syntax: `help`

## Add

### Adding a supplier: `add_supplier` or `add_s`

Adds a supplier to the list of suppliers.

Syntax: `add_supplier n/NAME p/PHONE_NUMBER e/EMAIL [t/TAG]…​`

* A supplier can have any number of tags (including 0).

Examples:

* `add_supplier n/John Doe p/98765432 e/johnd@example.com a/John Street`
* `add_s n/Betsy Cow t/diary e/betsycow@example.com a/Betsy Street p/1234567 t/meat`


### Adding an order: `add_order` or `add_o`

Adds an order into the list of orders.

Syntax: `add_order n/CUSTOMER_NAME l/CUSTOMER_LOCATION {p/CUSTOMER_PHONE_NUMBER e/CUSTOMER_EMAIL} d/DEADLINE q/QUANTITY f/FOOD_NAME [s/STATUS] [r/REMARKS]…​`

* An order can have any number of remarks.
* Either customer phone number or email address must be provided.
* Status available for setting are: Not Delivered, In Progress and Delivered.
* Key in `N` or `n` for Not Delivered, `I` or `i` for In Progress, and `D` or `d` for Delivered.
* If no status is provided, it is defaulted to Not Delivered.

Examples:

* `add_order n/John Doe l/John Street d/2023-12-12 q/10 f/Cupcakes p/91234567`
* `add_o r/Urgent f/Birthday Cake q/1 n/Betsy Cow l/Betsy Street d/2023-03-03 s/N`

### Adding a task: `add_task` or `add_t`

Adds a task to the list of tasks.

Syntax: `add_task n/TASK_DESCRIPTION d/DEADLINE [s/STATUS]`

* Status available for setting are: `N` / `n` (Not done), `D` / `d` (Done).
* If no status is provided, it is defaulted to `N` (Not done).

Examples:

* `add_task n/Buy cookie cutter d/2022-12-22`
* `add_t n/Buy a card d/2023-12-23 s/D`

### Adding a menu item: `add_item` / `add_i`

Adds a menu item to the menu.

Syntax: `add_item n/ITEM_NAME pr/PRICE c/COST`

* When entering price and cost data, you may input numbers with or without a decimal point.
* For example, you can input the number 5, or the number 5.75.

Examples:

* `add_item n/Chocolate cookie pr/5 c/2.50
* `add_i n/Harley Davidson Shirt pr/40 c/8.50`

## Edit

### Editing a supplier: `edit_supplier` or `edit_s`

Edit an existing supplier’s information.

Syntax: `edit_supplier INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

* Edits the supplier at the specified `INDEX`.
* The index refers to the number shown in the suppliers list displayed.
* The index **must be a positive integer** 1, 2, 3, …​
* User is required to key in at least one of the optional fields.
* Existing values will be replaced with the new values given.
* When editing tags, the existing tags of the supplier will be removed and replaced with the given tag (editing of tags is not accumulative).
* Typing `t/` without any input will remove all the existing tags.
* To change status, use `N` or `n` for Not Delivered, `I` or `i` for In Progress, and `D` or `d` for Delivered.

Examples:

* `edit_supplier 1 n/Johnny p/90138482 t/` edits the 1st supplier's name to `Johnny`, phone number to `90138482` and removed all of its tags
* `edit_s 3 t/Supplies Flour e/mark@example.com` replaced the 3rd supplier's tags to `Supplies Flour` and edited its email to `mark@example.com`


### Editing an order: `edit_order` or `edit_o`

Edits an order that is present in the order list.

Syntax: `edit_order INDEX [n/CUSTOMER_NAME] [l/CUSTOMER_LOCATION] [p/CUSTOMER_PHONE_NUMBER] [e/CUSTOMER_EMAIL] [d/DEADLINE] [q/QUANTITY] [f/FOOD_NAME] [s/STATUS] [r/REMARKS]…​`

* Edits the order at the specific `INDEX`. The index refers to the number shown in the orders list displayed. The index must be a positive integer 1, 2, 3, …
* User is required to key in at least one of the optional fields.
* Existing values will be replaced with the input values.
* When editing remarks, the existing remarks of the order will be removed and replaced with the given remarks (editing of tags is not accumulative).
* User can remove the remarks by typing r/ without specifying any remarks after it.

Examples:

* `edit_order 1 p/91234567 d/2023-05-05` edits the phone number of the 1st order to 91234567 and changes the deadline to be 2023-05-05
* `edit_o 3 q/20 r/` edits the quantity of food for the 3rd order to 20 and clears all remarks

### Editing a task: `edit_task` or `edit_t`

Edits a task present in the task list.

Syntax: `edit_task INDEX [n/TASK_DESCRIPTION] [d/DEADLINE] [s/STATUS]`

* Edits the task at the specific `INDEX`. The index refers to the number shown in the tasks list displayed. The index must be a positive integer 1, 2, 3, …
* User is required to key in at least one of the optional fields.
* Existing values will be replaced with the input values.
* When editing status, the existing status of the order will be removed and replaced with the given status.

Examples:

* `edit_task 1 n/Get creamer` edits the 1st task description to be "Get creamer"
* `edit_t 3 d/2023-12-31 s/N` edits the 3rd task deadline to 2023-12-31 and sets the status as not done

### Editing a menu item : `edit_item` / `edit_i`

Edits an item present in the menu.
Syntax: edit_item INDEX [n/ITEM_NAME] [pr/PRICE] [c/COST]

* Edits the item at the specific INDEX. The index refers to the number shown in the menu list displayed. The index must be a positive integer 1, 2, 3, …
* User is required to key in at least one of the optional fields.
* Existing values will be replaced with the input values.

Examples:

* edit_item 1 n/Coffee pr/2.50 c/1.50 edits the name of the first menu item to "Coffee", sets the price to $2.50 and the cost to $1.50.
* edit_i 3 d/Our signature burger p/8.99 c/2 edits the description of the third menu item to "Our signature burger", sets the price to $8.99 and the cost to $2.

## Find

### Finding a supplier: `find_supplier` or `find_s`

Find suppliers whose information matches with any of the given parameters.

Syntax: `find_supplier [n/NAME] [t/TAG]…​`

* Search is case-insensitive, e.g. `mark` will match `Mark`.
* The order of the keywords does not matter, e.g. `n/Mark Lee` will match with `Lee Mark`.
* At least one of the optional fields must be keyed in.
* More than one tag can be given.
* Only full words will match e.g. `Mar` will not match with `Mark`.
* People matching with at least one keyword will be returned (i.e. `OR` search).
  e.g. `n/Mark Lee` will return `Mark Tan`, `Lee Chan`.

Examples:

* `find_task n/PHOON HUAT` returns supplier `Phoon Huat` and `John Phoon`
* `find_s n/PHOON t/eggs t/flour` returns supplier `Phoon Huat` that supplies both `eggs` and `flour`

### Finding a task: `find_task` or `find_t`

Find tasks with information that matches with any of the given parameters.

Syntax: `find_task [n/TASK_DESCRIPTION] [d/DEADLINE] [s/STATUS]`

* Search is case-insensitive, e.g. `match` will match `Match`.
* The order of the keywords does not matter, e.g. `n/Mark Lee` will match with `Lee Mark`.
* At least one of the optional fields must be keyed in.
* Only full words will match e.g. `Mar` will not match with `Mark`.
* Tasks matching with at least one keyword will be returned (i.e. `OR` search).
  e.g. `n/order flour` will match with `order sugar` and `order 10kg flour`.

Examples:

* `find_task n/order flour` returns `Order milk` and `mix flour`
* `find_t n/buy eggs d/2023-02-17` returns tasks with `buy` or `egg` with deadline of `2023-02-17`
* `find_t s/N` returns all tasks not done

### Finding a menu item : `find_item` / `find_i`

Find tasks with information that matches with any of the given parameters.

Syntax: `find_item [n/ITEM_NAME]`

* Search is case-insensitive, e.g. `match` will match `Match`.
* The order of the keywords does not matter, e.g. `n/Chocolate cookies` will match with `Cookies chocolate`.
* At least one of the optional fields must be keyed in.
* Only full words will match e.g. `Choco` will not match with `Chocolate`.
* Menu Items matching with at least one keyword will be returned (i.e. `OR` search).
  e.g. `n/chocolate cookies` will match with `chocolate cupcake` and `hot chocolate`.

Examples:

* `find_item n/vanilla cupcake` returns `vanilla ice cream` and `Disney cupcake`
* `find_i n/shirt d/2023-02-17` returns menu items with `shirt`

## Delete

### Deleting a supplier: `delete_supplier` or `delete_s`

Deletes the specified supplier from the contact list.

Syntax: `delete_supplier INDEX`

* Deletes the task at the specified `INDEX`.
* The index refers to the number shown in the task list displayed.
* The index **must be a positive integer** 1, 2, 3, …

Examples:

* `delete_supplier 2` deletes the second supplier
* `find_s n/John` followed by `delete_s 3` deletes the 1st supplier in the results of the `find_s` command with name `John`

### Deleting an order: `delete_order` or `delete_o`

Syntax: `delete_order INDEX`

* Deletes the order at the specified `INDEX`.
* The index refers to the index number shown in the displayed order list.
* The index **must be a positive integer** 1, 2, 3, …

Examples:

* `list` followed by `delete_order 2` deletes the 2nd order in Trackr.
* `find Cake` followed by `delete_order 1` deletes the 1st order in the results of the `find` command.

### Deleting a task: `delete_task` or `delete_t`

Deletes the specified task from the task list.

Syntax: `delete_task INDEX`

* Deletes the task at the specified `INDEX`.
* The index refers to the number shown in the task list displayed.
* The index **must be a positive integer** 1, 2, 3, …

Examples:

* `delete_task 2` deletes the first task
* `find_t flour` followed by `delete_t 3` deletes the 1st task in the result of the `find_t` command

### Deleting a menu item: `delete_item` / `delete_i`

Deletes the specified item from the menu.

Syntax: `delete_item INDEX`

* Deletes the item at the specified `INDEX`.
* The index refers to the number shown in the menu displayed.
* The index **must be a positive integer** 1, 2, 3, …

Examples:

* `delete_menu 2` deletes the first task
* `find_i cupcake` followed by `delete_m 3` deletes the 1st menu item in the result of the `find_i` command

## Switch

### Sorting a task: `sort_task` / `sort_t`

Syntax: `sort_task [c/CRITERIA]`

* Sorts all the tasks according to a criteria.
* Criteria available are: `Time_added`, `Deadline`, `Status`, `Name` and `Status_and_deadline`.
* Criteria is case-insensitive (i.e. `time_added`, `TIME_ADDED` `Time_Added` are all valid).
* The default criteria (when no criteria is specified) is `Status_and_deadline`.

* Sorting by `Time_added` puts the tasks added first at the top and tasks added later below.
* Sorting by `Deadline` puts the tasks with the earlier deadlines on the top of tasks with further deadlines.
* Sorting by `Status` puts the tasks with "Not Done" status on top and tasks with "Done" status below.
* Sorting by `Name` sorts the tasks in a lexicographical order (ignoring-case) 
(i.e. A task with the task name "a" will be placed on top of a different task with the task name"B").
* Sorting by `Status_and_deadline` puts the tasks that are not done and have the earliest deadlines 
on top and tasks done and have the furthest deadlines below.
(i.e. Not done and earliest deadline > Not done and latest deadline > Done and earliest deadline > Not Done and latest deadline)

### Switching tabs: `tab`

Switch to another tab.

Syntax: `tab t/TAB`

* The available tabs are: `Home`, `Orders`, `Contacts`, `Menu`

Examples:

* `tab t/HOME` switches the tab to the `Home` tab

## Others

### Exiting the program: `exit`

Exits the program.

Syntax: `exit`

### Saving the data

Save changes after any command executed successfully. There is no need to save manually.

### Editing the data file

Trackr data are saved as a JSON file `[JAR file location]/data/trackr.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">
:exclamation: **Caution:**
If your changes to the data file makes its format invalid, Trackr will discard all data and start with an empty data file at the next run.
</div>

### Uploading a csv file

Uploads a valid csv file onto Trackr and parses each add command for `Task`, `Order` and `Suppliers`, and adds them to their respective lists. Below is an example of a valid csv file
![Valid csv file](images/CsvFileFormat.png)

### Upcoming features `[coming soon]`

* Different tabs for `Orders`, `Suppliers`
* Sort orders by date to keep track of orders.
* Highlight overdue orders.
* View list of all orders and tasks to prioritise your workload.
* View sales (tabulated or GUI) to track your business’s growth.

--------------------------------------------------------------------------------------------------------------------

# FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Trackr home folder.

--------------------------------------------------------------------------------------------------------------------

# Command summary

| Action     | Format, Examples                                                                                                                                                                                                                                                                                                  |
| ---------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Add**    | `add_supplier` or `add_s` <br> e.g., `add_s n/Betsy Cow t/diary e/betsycow@example.com a/Betsy Street p/1234567 t/meat` <br> <br> `add_order` or `add_o` <br> e.g., `add_o n/John Doe l/John Street d/2023-12-12 q/10 f/Cupcakes` <br> <br> `add_task` or `add_t` <br> e.g., `add_t d/Buy a card d/2023-12-23 s/Completed` |
| **Edit**   | `edit_supplier` or `edit_s` <br> e.g., `edit_s 3 t/Supplies Flour e/mark@example.com` <br> <br> `edit_order` or `edit_o` <br> e.g., `edit_o 3 q/20 r/` <br> <br> `edit_task` or `edit_t` <br> e.g., `edit_t 1 s/`                                                                                                          |
| **Delete** | `delete_supplier` or `delete_s` <br> e.g., `delete_s 2` <br> <br> `delete_order` or `delete_o` <br> e.g., `delete_o 1` <br> <br> `delete_task` or `delete_t` <br> e.g., `delete_t 4`                                                                                                                                       |
| **Find**   | `find_supplier` or `find_s` <br> e.g., `find_s n/PHOON t/eggs` <br> <br> `find_order` or `find_o` <br> e.g., `find_order r/No almonds r/No frosting` <br> <br> `find_task` or `find_t` <br> e.g., `find_t s/N`                                                                                                             |
| **Tab**    | `tab` <br> e.g., `tab Home`
|**Sort Task**| `sort_task` / `sort_t` <br> e.g., `sort_t c/Deadline`
| **Help**   | `help`                                                                                                                                                                                                                                                                                                            |
| **Exit**   | `exit`                                                                                                                                                                                                                                                                                                            |
