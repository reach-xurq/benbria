# !/bin/sh
#
# Parameters: suite_name browser
# Run a Selenium suite on Linux/Unix server. This script is intended to be run from Hudson.
# Set environment variables as needed.

SUITE=$1
BROWSER=$2
cd "$WORKSPACE"
echo "Running suite ${SUITE} on $XBOSOFT_TEST_URL, browser $BROWSER, from `pwd`"
# remove previous results
rm -rf ${SUITE}_results.html
# use node-specific variables
cp -f "$WORKSPACE/Benbria-IDE-scripts/Util/OverwriteGlobalVariables_Hudson_Linux.html" "$WORKSPACE/Benbria-IDE-scripts/Util/OverwriteGlobalVariables.html"
java -jar $SELENIUM_SERVER_JAR -port 4447 -htmlSuite $BROWSER $XBOSOFT_TEST_URL "$WORKSPACE/Benbria-IDE-scripts/${SUITE}TestSuite.html" ${SUITE}_results.html -userExtensions $SELENIUM_USER_EXTENSIONS -timeout $SELENIUM_TIMEOUT $3

