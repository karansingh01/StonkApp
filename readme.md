[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitlab.stud.idi.ntnu.no/it1901/groups-2021/gr2135/gr2135/-/blob/master/Stonk/ui/src/main/java/ui/StonkApp.java)

![](https://i.ibb.co/qxM02Nc/fb2bfc2bf0ed4c569cdf5b8168878d1b.png)

# STONK APP

**Stonk** is a stock ["Paper Trading"](https://www.investopedia.com/terms/p/papertrade.asp) application, where the stock prices get updated in real time. Trading with virtual money is a great way for beginners to learn how to trade in the financial markets, but also to experienced traders that want to test their trading strategies without any risk.

Our initial thought was to pull the stock prices using an API, but we decided against it as we needed a service that was free-of-charge. Therefore we get the stocks current price by web-scraping from marketwatch.com. We use .json files for saving information such as username, password and your balance. The reasoning behind this is that more advanced systems is not needed for a game like Stonk.

## how to use stonk app:
You can choose between registering a new accout or use on of ours.
If you want to see how an account with bought stocks looks like. You can log inn with:
- username: casper
- password: 12345

## Project file
You can find more information about the code in the project file. It is divided into three parts. core, data and ui.

### CORE:
Core is where we have our two main java classes Stonk.java and User.java. 
- User.java is where the user credentials are made.
- Stonk.java is the class that gets the information about the stock you want to look for by web scraping the web page matketwatch.
- This is where you can find theese files.
[Stonk>src>main>java>stonk...](https://gitlab.stud.idi.ntnu.no/it1901/groups-2021/gr2135/gr2135/-/tree/master/Stonk/src/main/java/stonk)


## Data
Data is the package for storing data and handling it. It gets handled with the datahandler and stored in Database.json
- You can fint it here:
[Stonk/data/src/main/java/data...](https://gitlab.stud.idi.ntnu.no/it1901/groups-2021/gr2135/gr2135/-/tree/master/Stonk/data/src/main/java/data)

### UI
UI is the package for where the user interface is made. Here the two main components are the fxml and Controller classes. The FXML files are where the actual user interface is made with scene buidler. THe controller classes it where the connection between the frontend and backend is. Here for instance the buttons from the fxml get their functions that tell them what to do.
- YOu can find the fxml files here:
[Stonk/ui/src/main/resources/ui/fxml...](https://gitlab.stud.idi.ntnu.no/it1901/groups-2021/gr2135/gr2135/-/tree/master/Stonk/ui/src/main/resources/ui/fxml)
- You can find the Controller classes here:
[Stonk/ui/src/main/java/ui...](https://gitlab.stud.idi.ntnu.no/it1901/groups-2021/gr2135/gr2135/-/tree/master/Stonk/ui/src/main/java/ui)


## Project architecture
#### click on image for better quality

Tree Structure of the app:
<a href="https://ibb.co/ChM8gLZ"><img src="https://i.ibb.co/gzP9NYp/tree-arc-all-IT-project.png" alt="tree-arc-all-IT-project" border="0"></a>

UI:
<a href="https://ibb.co/fxy20kd"><img src="https://i.ibb.co/qrcd1NY/tre-arkitektur.png" alt="tre-arkitektur" height="150px" width="100%" border="0"></a>