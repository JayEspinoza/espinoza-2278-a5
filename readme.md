# Assignment 5
The purpose of the program is to provide an easy method of inventory storage and management. The program stores items according to three parameters.

The Value parameter is in the form of a digit.
The Serial parameter is in an XXXXXXXXXX format where each X can be replaced with a number or letter.
The Name parameter is a simple string that must be between 2 and 256 characters in length.

# User Interface

The user interface consists of an output screen bounded by a single column consisting of commands. The commands are in the form of buttons that must be pressed to use their desired function.

## Inventory Commands

### Add Item
The user is prompted to input all 3 required parameters of an item. If not valid, the program will continue to prompt for them until cancelled or a valid parameter is entered.

### Remove item
The user is prompted for the serial number of the item that they want to remove. The item is then removed and the screen is updated.

### Load
The user is prompted for the name of a file. If that file is found, then the list is loaded, clearing the currently loaded list.

### Save
The user is prompted to give a name to a file. The list is then saved in a tsv format to the file.

### Name Sort/Value Sort/Serial Sort
The program sorts the list according to the type of sort that was picked.

### Name Search/Serial Search
The user is prompted for the parameter that they want to search. If  valid, the screen will display the searched item.

### Edit Name/Edit Value/Edit Serial
The user is prompted for the serial number of the item that they want to edit. When a valid serial number is entered, then the program asks for a valid replacement for the parameter that they have selected. The screen is updated.