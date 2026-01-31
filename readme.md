# ⚙️ 

	 A wizard that is used to create view objects in Android.

## 📁 Folder Structure
	src/
	├── CreatorTask/
	│   ├── BMExceptions/   
	│   ├── Factory/   # Factory initiating Builder and chains
	│   ├── BMHandler/   # selecting classes to create view objects
	│   │   └── Validators/
	│   ├── Builder/
	│	│	└── BMDirector/ # Primary Director
	│	│	└── Builders
	│	│		└── Class Builder View
	│	│		└── BMFromDirectorBuilder # director to create form object view
	│	│		└──	BuilderForms # Build object view form
	│	│		└──	Creator # an object that supplements data to the table that creates the view form object 
	│	│		└──	CreatorFormsan object that supplements data to the table that creates the view object
	│   ├──  DTO/      # Data Transfer Object
	│	└── BMServices
	bringmanage/             # Java Test

## ✅ Tests
	Is comming

## 🧩 Example
	services.nameTask("name")
               .header(id,value,margin)
                .contents(id,value,margin)
				.addButton(name form,id,label,runnable)
                .nameForm(name form)
				.addInputForm(name form,id,hint,value)
				.addButtonForm(name form,id,label,runnable)
                .addButtonForm("formFirst","contentSubmit","Dodaj")
                .get();

## Design patterns I use in the project
	Facade connecting a fluent object creating a DTO object and sending it to the factory
	Factory managing chains and directors
	Chain selecting classes to create view objects
	Director calling the builder class
	Builders creating views



