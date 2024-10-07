<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS TASK B 

## Task C (Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.) changes:
Changed page title in head on line 14 of mainscreen.html to "Sven's Snowboard & Ski Supplies" to fit branding of chosen customer type. 
Changed page header on line 19 of mainscreen.html to "Sven's Snowboard & Ski Supplies" to serve as header for welcome page.
Changed h2 on line 21 of mainscreen.html to "Bindings & Additional Parts" to make subheading more descriptive.
Changed h2 on line 53 of mainscreen.html to "Snowboards & Skis" to better represent complete products of chosen branding.

## Task D (Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.) changes:
Added "about.html" file to templates folder for new about page.
In about.html added similar head on lines 3-15 as to mainscreen with "About Us title".
In about.html added header with navigation to mainscreen.html on lines 16-22.
In about.html added div with h1 "how we serve you" and filler in paragraph below on lines 23-30.
in mainscreen.html on lines 16-22 added header with navigation link to about us page.
In controllers folder added "AboutController" file.


## Task E (Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.) changes:
All changes for this task are in BootStrapData.java.
Added if statements on lines 44 & 95 to check if there are parts or products in database before adding more.
Changed code on lines 45-55 to fit new "BurtonSnowboard binding" part.
Added "parkboardBase" part on lines 60-65.
Added "backCountryBoardBase" part on lines 67-72.
Added "parkSkiBase" part on lines 74-79.
Added "skiBindings" part on lines 81-86.
Added "burtonParkBoard" product on lines 97 and 102.
Added "burtonBackCountryBoard" Product on lines 98 and 103.
added "k2CrossCOuntrySkis" product on lines 99 and 104
Added "k2ParkSkis" product on lines 100 and 105.
Added "k2DownhillSkis" product on lines 101 and 106.

## Task F ( Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters: The “Buy Now” button must be next to the buttons that update and delete products, The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts, Display a message that indicates the success or failure of a purchase.) changes:
Implemented Buy Now buttons for both part table and product table on lines 62-65 and 107-110 of mainscreen.html.
Added PurchaseController.java class to controllers folder.
In PurchaseController buyPart method is implemented on lines 20-44.
In PurchaseController buyProduct method is implemented on lines 46-71.
Added purchaseSuccess.html to templates folder.
Added purchaseError.html to templates folder.

## Task G (Modify the parts to track maximum and minimum inventory by doing the following: Add additional fields to the part entity for maximum and minimum inventory, Modify the sample inventory to include the maximum and minimum fields, Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values, Rename the file the persistent storage is saved to, Modify the code to enforce that the inventory is between or at the minimum and maximum value.) changes:
In Part.java implemented minimumInventory and maximumInventory variables on lines 31-32 and 33-34 respectively.
In Part.java implemented new Part constructor on lines 57-64.
Added getter and setter methods for new variables on lines 106-112.
In BootStrapData.java I set values for the new minimumInventory and maximumInventory for each of the parts implemented on lines 51,52,67,68,76,77,85,86,94, and 95.
In OutsourcedPartForm.html added new fields for user to add minimum and maximum Inventory values on lines 26-29.
In InhousePartForm.html added new fields for user to add minimum and maximum Inventory values on lines 26-29.
Renamed file the persistent data is saved to to "SvensSnowboardsandSkisDatabase".
In Part.java implemented isInvValid method to test if inventory is valid on lines 118-120.
In AddInhousePartController.java implemented test to check if the part being added has a valid inventory on lines 44-46.
In AddOutsourcedPartController.java implemented test to check if the part being added has a valid inventory on lines 45-47.

## Task H (Add validation for between or at the maximum and minimum fields. The validation must include the following: Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts, Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum, Display error messages when adding and updating parts if the inventory is greater than the maximum.) changes:
In AddInhousePartController.java added else if statement to check if Inventory is bellow minimum on lines 45-48.
In AddInhousePartController.java added else if statement to check if Inventory is above maximum on lines 49-51.
In AddOutsourcedPartController.java added else if statement to check if Inventory is bellow minimum on lines 45-48.
In AddOutsourcedPartController.java added else if statement to check if Inventory is above maximum on lines 49-51.
In EnufPartsValidator.java restructured isValid to ensure adding inventory does not take total inventory bellow minimum on lines 35-44.

## Task I (Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.) changes:
In PartTest.java added a testMinimumInventory method which sets minimumInventory value of both partIn and partOut then uses assertEquals to ensure the assignment method works as intented on lines 160-167.
In PartTest.java added a testMaximumInventory method which sets maximumInventory value of both partIn and partOut then uses assertEquals to ensure the assignment method works as intented on lines 168-175.

## Task J (Remove the class files for any unused validators in order to clean your code.) changes:
In Validators folder removed DeletePartValidator due to it having 0 usages to clean code.

## Revisions
In EnufPartsValidator.java added validatePartsInventory method to check if adding a product would reduce associated part bellow minimum value on lines 49-66.
In AddProductController.java added else if to display error if adding a product would cause associated part to be bellow minimum on lines 77-80.