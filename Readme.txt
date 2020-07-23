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