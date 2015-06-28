CodeJam at McGill is an annual hackathon in which student programmers are asked to develop a solution to a real-life problem in 48 hours over the course of a weekend. [CodeJam 2013](http://www.mcgillcodejam.com/about-2/) happened on November 15-17. 

This year's problem was: 
Given a dataset detailing 2 years' worth of McGill's energy usage data along with temperature, humidity, time of day, etc., make a webapp (on [OpenShift](https://www.openshift.com/)) that predicts energy usage in the future for a specified time. "You must design a web application capable of predicting McGill’s power demand for a 16 hour window into the future (in 15 minute intervals)."
The web app would respond to a POST request containing input CSV data and output predictions.

We were able to get the machine-learning/data-mining part of it down; we trained a classifier using the M5P algorithm on the provided data set, and were able to use it to predict energy use for the future using a sample_input csv file with an error of around 3%-6%, but couldn't manage to get the webapp working in time.

We used [WEKA](http://www.cs.waikato.ac.nz/ml/weka/) for the data mining. WEKA allows you to do statisical analysis in Java.

Shivan Kaul Sahib and Niloofar Khoshsiyar worked on the data mining; Max Johnson and Amber Gamrat worked on the databasing/web interface.

We hope to expand on this project in the future: get the web interface working, plus maybe work on a GUI that displays relevant information.





The OpenShift `jbosseap` cartridge documentation can be found at:

https://github.com/openshift/origin-server/tree/master/cartridges/openshift-origin-cartridge-jbosseap/README.md
