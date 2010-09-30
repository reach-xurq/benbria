@ECHO off
REM
REM Parameters: suite_name browser
REM Run a Selenium suite on a Windows machine. This script is intended to be run from Hudson.
REM Set environment variables as needed.

set SUITE=%1
set BROWSER=%2
cd %WORKSPACE%
echo Running suite %SUITE%, on %XBOSOFT_TEST_URL%, browser %BROWSER%
REM remove previous results
del %SUITE%_results.html
REM use node-specific variables
copy /Y "%WORKSPACE%\Benbria-IDE-scripts\Util\OverwriteGlobalVariables_Hudson_Windows.html" "%WORKSPACE%\Benbria-IDE-scripts\Util\OverwriteGlobalVariables.html"
java -jar %SELENIUM_SERVER_JAR% -port 4447 -htmlSuite %BROWSER% %XBOSOFT_TEST_URL% "%WORKSPACE%/Benbria-IDE-scripts/%SUITE%TestSuite.html" %SUITE%_results.html -userExtensions %SELENIUM_USER_EXTENSIONS% -timeout %SELENIUM_TIMEOUT% %3

