		    _              _           _     _   _  __     _   _ _       
		   / \   _ __   __| |_ __ ___ (_) __| | | |/ /___ | |_| (_)_ __  
		  / _ \ | '_ \ / _` | '__/ _ \| |/ _` | | ' // _ \| __| | | '_ \ 
		 / ___ \| | | | (_| | | | (_) | | (_| | | . \ (_) | |_| | | | | |
		/_/   \_\_| |_|\__,_|_|  \___/|_|\__,_| |_|\_\___/ \__|_|_|_| |_|
		                                                                 
		 _____                _                            _        _     
		|  ___|   _ _ __   __| | __ _ _ __ ___   ___ _ __ | |_ __ _| |___ 
		| |_ | | | | '_ \ / _` |/ _` | '_ ` _ \ / _ \ '_ \| __/ _` | / __|
		|  _|| |_| | | | | (_| | (_| | | | | | |  __/ | | | || (_| | \__ \
		|_|   \__,_|_| |_|\__,_|\__,_|_| |_| |_|\___|_| |_|\__\__,_|_|___/
		                                                                  

DiceRoller
----------
	- If you're running a more complicated app on a slower phone, continually calling findViewById() could cause your app to lag. Instead it is a best practice to just call findViewById() once and store the View object in a field. Keeping the reference to the ImageView in a field allows the system to access the View directly at any time, which improves performance

	- Ideally you would initialize this variable up here when it's declared, or in a constructor—but Android activities don't use constructors. In fact, the views in the layout are not accessible objects in memory at all until after they have been inflated in the onCreate() method, by the call to setContentView(). You can't initialize the diceImage variable at all until that happens

	- The lateinit keyword promises the Kotlin compiler that the variable will be initialized before the code calls any operations on it. Therefore we don't need to initialize the variable to null here, and we can treat it as a non-nullable variable when we use it. It is a BEST PRACTICE to use lateinit with fields that hold views in just this way

	-  The tools namespace is used when you want to define placeholder content that is only used in the preview or the design editor in Android Studio. Attributes using the tools namespace are removed when you compile the app

	- Android Jetpack is a collection of libraries, developed by Google, that offers backward-compatible classes and helpful functions for supporting older versions of Android. Jetpack replaces and expands on the set of libraries formerly known as the Android Support Library

	-  In general, if your app can use a compatibility class from the Jetpack libraries, it should use one of those classes, because those classes provide support for the largest possible number of features and devices

	- An important thing to note about vector drawables is that they are supported in API 21 onwards. But your app's minimum SDK is set to API 19. If you tried your app on an API 19 device or emulator, you'd see that the app seems to build and run just fine. So how does this work? When you build your app, the Gradle build process generates a PNG file from each of the vector files, and those PNG files are used on any Android device below 21. These extra PNG files increase the size of your app. Unnecessarily large apps aren't great—they make downloads slower for users and take up more of their devices' limited space. Large apps also have a higher chance of being uninstalled, and of users failing to download or canceling downloads of those apps.
	To use to compat library for vector drawables:
	vectorDrawables.useSupportLibrary = true >> Build.gradle
	and use srcCompat instead of src

	- If you have a widget that has a png/vector drawable background set by android:background, and you want to change its default color, then you can use android:backgroundTint to add a shade to it.

	- If you try to change the accent color of the FloatingActionButton using android:background you won't notice a change, that is because it's already utilizes app:srcCompat, so in order to do that you can use android:backgroundTint instead


About Me
--------
	- A ViewGroup is a view that can contain child views, which are other views and view groups. Views that make up a layout are organized as a hierarchy of views with a view group as the root

	- android:layout_marginLeft should become android:layout_marginStart to support RTL languages

	- New Font from google font can be added from layout editor

	- Right-click the TextView in the Component Tree and select Refactor > Extract Style

	- Showing and Hiding Keyboard



Color My Views
--------------
	- ConstraintContainerLayout : You'll add constraints manually, so you want autoconnect turned off. In the toolbar, locate the Turn Off/On Autoconnect toggle button, which is shown below. (If you can't see the toolbar, click inside the design editor area of the Layout Editor.) Make sure autoconnect is off

	- Use the toolbar to set the default margins

	- Constraint bias positions the view element along the horizontal and vertical axes. By default, the view is centered between the two constraints with a bias of 50%

	- Match Constraints: The view expands as much as possible to meet the constraints on each side, after accounting for the view's own margins. This constraint is very flexible, because it allows the layout to adapt to different screen sizes and orientations. By letting the view match the constraints, you need fewer layouts for the app you're building

	- A chain is a group of views that are linked to each other with bidirectional constraints. The views within a chain can be distributed either vertically or horizontally. For example, the following diagram shows two views that are constrained to each other, which creates a horizontal chain.

	- The first view in a chain is called the head of the chain. The attributes that are set on the head of the chain control, position, and distribute all the views in the chain. For horizontal chains, the head is the left-most view. For vertical chains, the head is the top-most view

	- Chain styles define the way the chained views are spread out and aligned. You style a chain by assigning a chain style attribute, adding weight, or setting bias on the views


Data Binding
------------
	- Every time you use findViewById() to search for a view after the view is created or recreated, the Android system traverses the view hierarchy at runtime to find it. When your app has only a handful of views, this is not a problem. However, production apps may have dozens of views in a layout, and even with the best design, there will be nested views

	- One solution is to create an object that contains a reference to each view. This object, called a Binding object, can be used by your whole app. This technique is called data binding. Once a binding object has been created for your app, you can access the views, and other data, through the binding object, without having to traverse the view hierarchy or search for the data

	- To use data binding, you need to enable data binding in your Gradle file, as it's not enabled by default. This is because data binding increases compile time and may affect app startup time

	- You can take advantage of data binding to make a data class directly available to a view. This technique simplifies the code, and is extremely valuable for handling more complex cases


Android-Trivia
--------------
	- To use the navigation library, you need to add the navigation dependencies to your Gradle files and Add a navigation graph to the project

	- A navigation host fragment acts as a host for the fragments in a navigation graph. The navigation host fragment is usually named NavHostFragment. As the user moves between destinations defined in the navigation graph, the navigation host fragment swaps fragments in and out as necessary. The fragment also creates and manages the appropriate fragment back stack

	- If the preview shows a "Preview Unavailable" message, click the Text tab to open the navigation XML. Make sure that the fragment element for the gameFragment includes tools:layout="@layout/fragment_game".

	- When the user presses the Back button, the app goes to the destination that's at the top of the back stack. By default, the top of the back stack is the screen that the user last viewed. The Back button is typically the left-most button at the bottom of the screen, as shown below. (The Back button's exact appearance is different on different devices.)

	- The popUpTo attribute of an action "pops up" the back stack to a given destination before navigating. (Destinations are removed from the back stack.) If the popUpToInclusive attribute is false or is not set, popUpTo removes destinations up to the specified destination, but leaves the specified destination in the back stack. If popUpToInclusive is set to true, the popUpTo attribute removes all destinations up to and including the given destination from the back stack. If popUpToInclusive is true and popUpTo is set to the app's starting location, the action removes all app destinations from the back stack. The Back button takes the user all the way out of the app.

	- The navigation components includes a UI library called NavigationUI. The navigation controller integrates with the app bar to implement the behavior of the Up button, so you don't have to do it yourself.

	- If you use the same ID for the menu item as for the destination fragment, you don't need to write any code at all to implement the onClick listener!


NavDirection
------------
	- Do not edit the NavDirection classes. These classes are regenerated whenever the project is compiled, and your edits will be lost.

	- Before users can share their game results from within the AndroidTrivia app, your code needs to pass parameters from one fragment to another. To prevent bugs in these transactions and make them type-safe, you use a Gradle plugin called Safe Args. The plugin generates NavDirection classes, and you add these classes to your code.

	- Your app could use a Bundle to pass data from fragment A to fragment B. For example, fragment A creates a bundle and saves the information as key-value pairs, then passes the Bundle to fragment B. Then fragment B uses a key to fetch a key-value pair from the Bundle. This technique works, but it can result in code that compiles but then has the potential to cause errors when the app runs.

	- When you use "safe arguments," you can replace fragment classes that are used in navigation code with NavDirection classes. You do this so that you can use type-safe arguments with other fragments in the app.

	- An Intent is a simple message object that's used to communicate between Android components. With an implicit intent, you initiate an activity without knowing which app or activity will handle the task. For example, if you want your app to take a photo, you typically don't care which app or activity performs the task. When multiple Android apps can handle the same implicit intent, Android shows the user a chooser, so that the user can select an app to handle the request.

	- Each implicit intent must have an ACTION that describes the type of thing that is to be done. Common actions, such as ACTION_VIEW, ACTION_EDIT, and ACTION_DIAL, are defined in the Intent class.


Dessert Clicker
---------------
	- Application is a base class that contains global application state for your entire app. It's also the main object that the operating system uses to interact with your app. There is a default Application class that Android uses if you don't specify one, so there's always an Application object created for your app, without you needing to do anything special to create it.

	- It might be tempting to add your own code to the Application class, because the class is created before all of your activities and can hold global state. But just as it's error-prone to make readable and writable static variables that are globally available, it's easy to abuse the Application class. Avoid putting any activity code in the Application class unless the code is really needed.

	- The important point here is that onStart() and onStop() are called multiple times as the user navigates to and from the activity. You should override these methods to stop the app when it moves into the background, or start it up again when it returns to the foreground

	- So what about onRestart()? The onRestart() method is much like onCreate(). Either onCreate() or onRestart() is called before the activity becomes visible. The onCreate() method is called only the first time, and onRestart() is called after that. The onRestart() method is a place to put code that you only want to call if your activity is not being started for the first time.

	- Whatever code runs in onPause() blocks other things from displaying, so keep the code in onPause() lightweight. For example, if a phone call comes in, the code in onPause() may delay the incoming-call notification.

	- Both onResume() and onPause() have to do with focus. The onResume() method is called when the activity has focus, and onPause() is called when the activity loses focus


GuessTheWord
------------
	- App architecture is a way of designing your apps' classes, and the relationships between them, such that the code is organized, performs well in particular scenarios, and is easy to work with. In this set of four codelabs, the improvements that you make to the GuessTheWord app follow the Android app architecture guidelines, and you use Android Architecture Components. The Android app architecture is similar to the MVVM (model-view-viewmodel) architectural pattern.

	- A UI controller is a UI-based class such as Activity or Fragment. A UI controller should only contain logic that handles UI and operating-system interactions such as displaying views and capturing user input. Don't put decision-making logic, such as logic that determines the text to display, into the UI controller.

	- A ViewModel holds data to be displayed in a fragment or activity associated with the ViewModel. A ViewModel can do simple calculations and transformations on data to prepare the data to be displayed by the UI controller. In this architecture, the ViewModel performs the decision-making.

	- A ViewModelFactory instantiates ViewModel objects, with or without constructor parameters.

	- During configuration changes such as screen rotations, UI controllers such as fragments are re-created. However, ViewModel instances survive. If you create the ViewModel instance using the ViewModel class, a new object is created every time the fragment is re-created. Instead, create the ViewModel instance using a ViewModelProvider.

	- The ViewModel should never contain references to fragments, activities, or views, because activities, fragments, and views do not survive configuration changes.