# !/bin/sh
#
# Parameters: suite_name browser
# Run a Selenium suite on Linux/Unix server without GUI (start a framebuffer for X windows). This script is intended to be run from Hudson.
# Set environment variables as needed.

# configure headless mode for firefox
Xvfb :55 -ac >> /dev/null 2>&1 &
export DISPLAY=:55
./runSuite_Linux.sh $*

