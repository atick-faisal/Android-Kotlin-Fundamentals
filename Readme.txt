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

	- An important thing to note about vector drawables is that they are supported in API 21 onwards. But your app's minimum SDK is set to API 19. If you tried your app on an API 19 device or emulator, you'd see that the app seems to build and run just fine. So how does this work?
	When you build your app, the Gradle build process generates a PNG file from each of the vector files, and those PNG files are used on any Android device below 21. These extra PNG files increase the size of your app. Unnecessarily large apps aren't great—they make downloads slower for users and take up more of their devices' limited space. Large apps also have a higher chance of being uninstalled, and of users failing to download or canceling downloads of those apps.
	To use to compat library for vector drawables:
	vectorDrawables.useSupportLibrary = true >> Build.gradle
	and use srcCompat instead of src