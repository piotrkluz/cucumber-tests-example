# Architectural Decision Record

## Choose WebDriver instance managment for cucumber
**Background**: Every time when open browser takes 5-10s time. 
The goal is to have one instance of WebDriver in entire test suite. To do it needs instantiate browser before all tests, and quit after all of them. 
Unfortunately Cucumber doesn't provide hooks like `@AfterAll`, or `@BeforeAll`. Create new instance is available in `@Before` hook, but quit driver is not so simple.

**Resolution**:
WebDriverManager is used to download latest `chromedriver.exe` / `geckodriver.exe` etc.
Cucumber Plugins originally used for reporting, gives way to inject code into more test run moments that are needed. 
Choose browser is made by parameter `--plugin DriverPlugin:chrome`. 
Multi-thread work will be available, after modify plugin to implement `ConcurrentEventListener` and slightly modify DriverStore to keep multiple windows.