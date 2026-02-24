
# CreatorView

A small wizard/fluent API for programmatically creating Android view structures (headers, contents and forms). CreatorView provides a fluent Builder/Factory/Facade-style API that produces a LinearLayout containing dynamic UI elements based on a DTO description.

This repository contains a prototype implementation intended as a library component and a usage example.

## Table of contents
- Quick Start
- Example
- Folder structure
- Design & architecture
- Recommendations & known limitations
- Tests
- Contributing
- License

## Quick Start

CreatorView is a library-level prototype. To use it in an Android app:

1. Add the library module or include source files into your Android project.
2. Ensure your app has the required resources (layouts and IDs referenced by the example).
3. Instantiate BMServices (via a ViewModel in the example) and build the UI with the fluent API.

Minimal usage (example from MainActivity):

```java
MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
BMServices services = viewModel.getServices();

LinearLayout dynamicLayout = services
    .nameTask("First")
    .header("contentHeader", "ManageTask", new int[]{0, 15, 0, 15})
    .contents("contentText", "Aplikacja do zarzadzania zadaniami", new int[]{0, 15, 0, 15}, "Black")
    .nameForm("formFirst")
    .addInputForm("formFirst", "inputFirst", "", "Dodaj nowe zadanie ...")
    .addButtonForm("formFirst", "contentSubmit", "Dodaj")
    .get();

LinearLayout container = findViewById(R.id.mainContainer);
container.addView(dynamicLayout);
```

Notes:
- The example assumes `R.layout.activity_main` and `R.id.mainContainer` exist in your app resources.
- `get()` returns a LinearLayout built by the factory from the DTO assembled by BMServices.

## Example

See `MainActivity.java` for a simple example of how to use CreatorView inside an Activity. The intended flow is:
1. Create/obtain BMServices (in the example via MainViewModel).
2. Build DTO via fluent API calls (nameTask → header/contents → nameForm → add form inputs/buttons).
3. Call `get()` to produce the LinearLayout with created views.
4. Insert the resulting view into your Activity/container.

## Folder structure (intended)
src/
- CreatorTask/
  - BMExceptions/      (exceptions used by the library)
  - Factory/           (factory that turns DTO into Android Views)
  - BMHandler/         (chain/handler logic to pick builders)
  - Builder/           (builders/directors responsible for creating views)
  - DTO/               (data transfer objects used by the API)
  - BMServices.java    (fluent API / facade used to create DTO)
- bringmanage/         (example / test app files like MainActivity, MainViewModel)

Some folders may be placeholders or incomplete in this repository — check the codebase for implemented files.

## Design & architecture

CreatorView uses several design patterns:
- Facade: BMServices provides a simple fluent facade to build view descriptions (DTO).
- Builder/Director: Builders create concrete Android Views from DTO data.
- Factory: BMFactory coordinates builders and produces the final LinearLayout.
- Chain of Responsibility: BMHandler/chain selects appropriate builders for DTO parts.

The API is intentionally fluent so you can chain calls to build a complete view description before rendering.

## Recommendations & known limitations

This project is currently a prototype. A few important points to keep in mind:
- The library expects to run inside an Android app (requires Android Context and resources).
- The sample Activity references layout resources that may not be present in the repo. Add a sample `activity_main.xml` and container view id if you want to run the demo out of the box.
- Some API edge cases must be handled carefully (e.g., ensure BMServices.query is initialized before calling methods). Consider adding validations and unit tests when stabilizing the API.
- Overloaded methods should be consistent: avoid unused parameters and ensure each overload behaves predictably.

If you plan to publish this as a reusable library, consider:
- Adding unit tests (and Robolectric if you want to test view-building logic).
- Running static analysis (SpotBugs/Checkstyle) and formatting (Google Java Format).
- Providing a small sample app module and build.gradle files to simplify testing and demos.
- Packaging as an AAR and publishing with proper versioning.

## Tests

There are no unit tests in the current repository. Recommended test coverage:
- BMServices: ensure DTO assembly is correct for many combinations (multiple forms, multiple inputs, missing nameTask, etc.)
- BMFactory/builders: verify the produced Views contain the expected hierarchy and properties (use Robolectric for headless testing).

## Contributing

Contributions, improvements and bug reports are welcome.

Before contributing:
- Run formatter and linter (if configured).
- Add unit tests covering new/changed behavior.
- Keep API changes backward compatible where possible; document breaking changes clearly in the changelog.

How to contribute:
1. Fork the repository.
2. Create a feature branch: git checkout -b feature/your-feature
3. Make changes, add tests and documentation.
4. Open a pull request describing your changes.

## Changelog & roadmap

Consider adding a CHANGELOG.md if you plan to do releases. Example roadmap items:
- Stabilize BMServices API and fix known NPE/collection issues.
- Add sample Android app module with resources and Gradle config.
- Add unit tests and CI workflow (GitHub Actions).
- Package and publish AAR to a Maven/GitHub Package registry.

## License

This project is licensed under the MIT License — see LICENSE for details.