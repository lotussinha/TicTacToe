# Branch Android SDK change log
- v5.0.4
  * _*Master Release*_ - November 19, 2020
  * Reduce calls to v1/close
  * Fix validator errors

- v5.0.3
  * _*Master Release*_ - August 10, 2020
  * Upgrade referrer library
  
- v5.0.2
  * _*Master Release*_ - July 22, 2020
  * Remove content discovery

- v5.0.1
  * _*Master Release*_ - March 8, 2020
  * Report GAID when test key is used
  * Detect TUNE migrations, report them via the `update` field in open/install payload
  * Deprecate enableSimulateInstalls
  * Deprecate enableDebugMode
  * Modify enableTestMode
  * Support for air-preload campaigns via Play Install Referrer API

- v5.0.0
  * _*Master Release*_ - March 17, 2020
  * Bump up major version to signify switch to session builder from initSession (old functionality is maintained)
  * Added documentation with 1:1 session builder replacements of deprecated initSession methods
  * Add disableAdNetworkCallouts(boolean) API

- v4.4.0
  * _*Master Release*_ - March 12, 2020
  * Do not check Facebook app links unless feature is explicitly enabled
  * Introduce Branch.sessionBuilder().<...>.init() to replace all overloaded variations of initSession
  * Introduce Branch.expectDelayedSessionInitialization(boolean) which disables session self-initialization in RESUMED state, users MUST initialize themselves when using this method
  * Introduce Branch.sessionBuilder().withDelay(X_MILLIS) to facilitate delaying session initialization until user calls branchInstance.removeSessionInitializationDelay() or X_MILLIS pass.
  * Prevent duplicated session initialization in certain intra-app linking scenarios
  * Collect OAID from HMS when available
  * Prevent potential NPE in the CPID API
  * Improvements in instant deep-linking

- v4.3.2
  * _*Master Release*_ - January 29, 2020
  * Accommodate single activity architecture/navigation component (reintroduced "SDK already initialized" error and ensured reInitSession() only fires when intent contains branch data).
  * Do not self-initialize if SDK is bundled with a plugin.
  
- v4.3.1
  * _*Master Release*_ - January 23, 2020
  * Hotfix revert CPID and LATD listener paths to the newer version.
  * Replace "SDK already initialized" error with logs and return latest referring parameters.

- v4.3.0
  * _*Master Release*_ - January 22, 2020
  * Drop broadcast receiver and bundle Play Install Referrer Library.
  * Fix CPID and LATD listener paths.
  * Annotate @Nullable initSession callback parameters, so callback is not dropped in kotlin.
  
- v4.2.1
  * _*Master Release*_ - December 19, 2019
  * Make attribution window optional for LATD requests
  * Remove fake email stub from share sheet on Android TVs
  
- v4.2.0
  * _*Master Release*_ - November 19, 2019
  * Remove initialization race conditions.
  * Only self-initialize sessions if user has not done so and some Activity is entering the RESUMED state.
  * Start returning an error on consecutive session initializations. Note, this means users who require deeplinking functionality now must call initSession() from LauncherActivity.onStart() (the requirement was already implied in the documentation, though was not enforced, the SDK was returning latestReferringParams instead, which users in need of a workaround can still do).
  * Overload reInitSession with different callbacks and start advertising it to users as the official way to handle session reinitialization in cases where activity is in foreground and is being reopened.
  * Make sure carrier field does not contain an empty string, omit the field instead.
  
- v4.1.2
  * _*Master Release*_ - October 30, 2019
  * Enabled setting custom CDN URL
  * Fixed button clickability on devices without touchscreen
  * Added extra fields to open/install and event endpoints

- v4.1.1
  * _*Master Release*_ - October 7, 2019
  * Support for Fire OS
  * Do not collect advertising ID when limit ad tracking is enabled after the app was initialized

- v4.1.0
  * _*Master Release*_ - September 26, 2019
  * Support for CPID
  * Support for Last Attributed Touch Data

- v4.0.1
  * _*Master Release*_ - September 18, 2019
  * SDK-237 corrected customer_event_alias function
  * SDK-211 support for optional plugin

- v4.0.0
  * _*Master Release*_ - August 6, 2019
  * Switched to using Android X from the Android Support Library
  * Added new standard event type: customer_event_alias
  * Implemented support for pre-install analytics
  * Added the option to set a custom base URL

- v3.2.0
  * _*Master Release*_ - May 2, 2019
  * SDK-271 Allow short link creation while privacy is enabled

- v3.1.2
  * _*Master Release*_ - April 16, 2019
  * Hardware ID is now included in every request
  * Cleaned up compiler warnings, and updated tools to the latest versions

- v3.1.1
  * Added support for push notifications while the application is in the foreground

- v3.1.0
  * Fixed a synchronization issue around the event queue saving preferences while in a synchronized block.
  * Added new standard events for parity with Tune.
  * Ensure that Google Aid is present in all requests.
  * Refactored how Debug works, including making sure all Debug messages can be turned off if not in debug mode.

- v3.0.4
  * Fixed a TLS1.2 issue with HttpsURLConnection on API Level 16~19 devices
  * Add SDK version tag to the Android SDK to aid Google Scanning APIs
  * The SDK now supports deeplinking with enableForcedSession() for apps which choose to finish the Launcher Activity within onStart() method

- v3.0.3
  * _*Master Release*_ - December 6, 2018
  * Fixed Android InstallListener exception when not on UI thread. SDK-87

- v3.0.2
  * _*Master Release*_ - November 30, 2018
  * Fix DeadSystemException crash in System Observer. INTENG-4460

- v3.0.1
  * _*Master Release*_ - November 8, 2018
  * Fix unstable share sheet row height. DEVEX-835
  * Added new method to force init session. INTENG-4322
  * Support untagged sockets. DEVEX-888

- v3.0.0
  * _*Master Release*_ - October 26, 2018
  * Upgrade to api2.branch.io for TLS 1.2+ support. DEVEX-809
  * _Breaking Change_ Min SDK version is now 16. If you want to support minimum sdk level 9 please consider using version 1.14.5. If you want to to support a minimum SDK of 15, use the 2.x versions.

- v2.19.5
  * _*Master Release*_ - October 8, 2018
  * Added new way to init session for attribution (`initSessionForced`) INTENG-4285

- v2.19.4
  * _*Master Release*_ - October 1, 2018
  * Adding Branch Universal Object to custom event request. DEVEX-761
  * Send GAID with v1/event. DEVEX-766
  * Adding ability to do instant deep linking with App Links. DEVEX-776

- v2.19.3
  * _*Master Release*_ - August 22, 2018
  * Changed post request logic to close streams. [#600](https://github.com/BranchMetrics/android-branch-deep-linking/issues/600)
  * Added check for if `BranchEvent` is same name as `BRANCH_STANDARD_EVENT` name, send with `v2/event/standard` request. DEVEX-751

- v2.19.2
  * _*Master Release*_ - August 10, 2018
  * Added notify network API to process requests when network is available. DEVEX-711

- v2.19.1 Fixed GAID fetch issue.

- v2.19.0 Support for adding custom install metadata. Fix for an ANR in debug mode. Fix for crash caused by reading user agent. SDK Integration validator.

- v2.18.1 Fixing issue with facebook app link check caused by incorrect value for facebook_app_link_checked state. Fix for app indexing to run on separate thread.

- v2.18.0 Removing unnecessary String conversion for deeplink data JSONObject. This will fix the issue of additional escape characters present in the deep link data

- v2.17.1 Hot fix : Preference items cleared over app re-open if Branch key is missing in manifest file.

- v2.17.0 Adding tracking disable feature, this is useful for GDPR compliance. Fixing share sheet to show correct selection. Fix for updating device params to Branch requests before sending. Updating to latest Gradle version. Few other minor fixes.

- v2.16.0 Adding support for collecting data from selected URIs with remote skip list update feature. Fixing an issue with handling BUO metadata.

- v2.15.1 Hot fix : Install requests getting stuck in the request queue if failed once. Caused by improper install referrer wait lock addition to install request.

- v2.15.0 Adding support for Android install referrer lib. Changing instant deep linking into opt-in feature. Collecting install timestamps for better install or update attributions.

- v2.14.5 Hot fix: Re-open after offline install event fails. Support for modifying deep link data and link params on share sheet events.

- v2.14.4 Fixing a possible request queue concurrent execution. Adding support for opt-out IDL. Fix for maintaining strong typing for arrays when BUO is serialised. Adding extended catch for dealing with dead object. Support for "rating" property in content metadata.

- v2.14.3 Fixing a corner case crash from concurrent modification case. Fixing issue with deep link param delivery after orientation change.

- v2.14.2 Adding FB limit app tracking. Fix for instant deep liking when activities are launched from the stack. Few other minor fixes.

- v2.14.1 Ensure backward compatibility in case deprecated BUO methods are used.

- v2.14.0 Adding support for Branch reserved events. Support to update delayed request metadata. Skipping instant deep linking on forcing new session.

- v2.13.1 Hot fix : Referral params are not returned when initSession is called mutiple times while an init session is in progress

- v2.13.0 Adding instant deeplinking support

- v2.12.2 Fixing play store referrer capture issue on Android 6. Changes to collect UI_Mode to identity different platforms.  Fix for stale intents when activities are launched from history.

- v2.12.1 Fixing discrepancy in Branch driven app open count in Answers' dashboard. Adding bounds to share sheet and option to set bounds.

- v2.12.0 Adding support for Firebase based app indexing and local content indexing. Few proactive protections for parcel errors caused by malformed parcels in the intent. Url encoding for long link params.

- v2.11.1 Removing app listing related implementations.

- v2.11.0 Disabling external app listing is by default.

- v2.10.3 Fix for reading intent from launcher activity only unless forced to restart session. Instant app utility methods fix for Android `O`

- v2.10.2 More reliable install referrer capture. URL encoding for supporting referring links added in play store referrer

- v2.10.1 Deprecating enablePlayStoreReferrer()

- v2.10.0 Added changes to capture raw play store referrer string when Google search install referrer is present

- v2.9.1 Hot fix for a possible app crash on instant app to full app conversion

- v2.9.0 Adding network layer abstraction to build custom network layer. Apps can build their own network implementation to handle Branch network requests. By default Branch will be using URL connection for handling network requests.

- v2.8.0 Adding Instant App support. Supports Instant App content deep linking, Full app conversion with deep linking and associated conversion attributions.

- v2.7.0 Moved `BranchLinkUsed` to intent extra. Fixed ability to simulate is_first_session:true when testing. CD Revamp.

- v2.6.1 Adding environment variables. Enhancement to CD.

- v2.6.0 Fix for NPE edge case. Added configurable delay between strong match url- init. Added support for Google Install Referrer ID.

- v2.5.9 Fix for strong match NPE.

- v2.5.8 Fix for getAppVersion, added matching via PlayStore install broadcast intent, modifications to strong match url.

- v2.5.7 Fix for ShareSheet Airplane mode, updated commerceevent defaults, Added feature for sharesheet to whitelist/blacklist apps by package name. Added synchronous
  getLatestReferringParams and getFirstReferringParams.

- v2.5.6 Fix for sharesheet title, extra intent data fix, added commerceevent function.

- v2.5.5 Added function to init Branch w/ key programmatically (vs having to use Manifest file).

- v2.5.4 Fix to better register opens/installs. Added enableTestMode/disableTestMode static functions.

- v2.5.3 Fix to disable FB app link check by default.

- v2.5.2 Fix for Android/iOS link-click compatibility when used with BUO. Fixed doc formatting for latest Android Studio version.

- v2.5.1 Fix for init session not being called when used from onCreate().

- v2.5.0 Changing chrome tabs dependency optional. Adding option to simulate and test install. Few corner error  handling

- v2.4.7 Fix for cold start issue with deeplink parameters on slower internet connection. Added local ip address as part of device params

- v2.4.6 Fixed issue with receiving deep link prams through push notification while app is running in foreground. Added device locale info for stronger matching.

- v2.4.5 Adding fix for transaction too large exception while auto deep linking. Fixing invalid argument exception while reading params from intent.

- v2.4.4 Adding ability to skip collecting external intent data specific to URI host. Adding NPE protection for custom tab session access

- v2.4.3 Adding ability to skip collecting external intent data specific to URI paths

- v2.4.2 Removes the unnecessary support package dependencies

- v2.4.1 Updating minimum SDK version to 15.

- v2.4.0 Adding Cookie based matching support. Fixing few format issues and updating documentation.

- v2.3.1 Correcting BUO Action name View to VIEW

- v2.3.0 Enhancements to Branch universal object. Support for campaign in link properties

- v2.2.0 Adding Branch Content Discovery feature.

- v2.1.0 Replacing answers-shim dependency with Crashlytics answers shim to fix build conflict when Branch is used along with Digits.

- v2.0.3 Hot fix for NPE with get request when Branch API services is down.

- v2.0.2 Support for delayed "onNewIntent()" call on certain Android versions. Clean up for unused server requests.

- v2.0.1 Adding an option to white list the Uri schemes that should be collected by Branch SDK when app is opened with an external intent.

- v2.0.0: Removing support for Manual session handling. This version onwards only Auto session management is supported. This requires minimum API level set to 14 or above.
  If not using auto session already please call "Branch.getAutoInstance(application)" from your Application Classes "onCreate()" method.
  If your application doesn't have an Application class just use "BranchApp" as your application class by adding it in manifest(add "android:name="BranchApp" in application tag")
  There is not need to call "closeSession()" API explicitly. If you want to support minimum API level less than 9 please consider using SDK version 1.14.5 (support minimum sdk version 9)

- v1.14.5: Using Thread Pool to execute Branch request in parallel to improve Branch API response time. Optimizations for performance improvements

- v1.14.4: Adding more styling options to Share Sheet. Disabling Facebook App-Link check by default.

- v1.14.3: Cleaner fix for jcenter dependency issue.

- v1.14.2: HotFix: Build version not updated issue.

- v1.14.1: adding update option for Answers-Shim SDK.

- v1.14.0: Fabric Answers integration.

- v1.13.1: Hot Fix : Design changes to ensure init callbacks are always called. Relocating fabric properties file.

- v1.13.0: Adding feature to turn on/off collecting device id.

- v1.12.1: Hot fix : initSession is not called back on some scenarios with the new feature added on 1.12.0.

- v1.12.0: Added check for Facebook App Links on client side. Added support for list BUO in Google search. Support for adding metadata to Branch requests.

- v1.11.3: Adding more client side error handling for BranchViews.

- v1.11.2: Removing unnecessary device param capture.

- v1.11.1: Adding support for customising share sheet messages.

- v1.11.0: Adding SDK support for application landing pages.

- v1.10.8: Hot fix for NPE caused by 1.10.7.

- v1.10.7: Hot fix for a possible memory leak caused by holding strong reference to context.

- v1.10.6: Few enhancements to cached link data matching before making a create url call.

- v1.10.5: Removing touch debug feature and some deprecated methods.

- v1.10.4: Fix for corner case concurrent modification error present in 1.10.3.

- v1.10.3: Fix for incorrect params on init with app-links. Fix for concurrent modification error and few other bugs. Added error codes for Branch errors.

- v1.10.2: Added instrumentation support and deep link debug feature.

- v1.10.1: Added fix for crash issues with share sheet. Added more specific error messages.

- v1.10.0: Added support for the brand new BranchUniversalObject for easy tracking of views on content, easy creation of links and easy sharing

- v1.9.0: Support for Android App-links. Deprecating loadActionCount API

- v1.8.12: Fix for issue link parameters are provided in init session callback multiple times. Bug fixes for handling requests queued before initialising session.

- v1.8.11: Fix for issue deep link params are empty when session initialised on with a delay with a multi threaded environment.

- v1.8.10: Fix for a possible NPE on sharing link in slow network conditions.

- v1.8.9: Fix issue requests not removed from request queue on resource conflict. Fixing couple of possible NPE and Memory leaks.

- v1.8.8: Fix for callback not invoked on session error when creating a short link with builder.

- v1.8.7: Adding internationalization support for sharing link builder. Additional callbacks are also added to notify sharing dialog is launch and dismiss events.

- v1.8.6: Adding option to specify email/sms subject to the share link builder.

- v1.8.5: Fix crash on install app from market due to referrer string parse error.

- v1.8.4: Deprecate setDebug and migrate to use <meta-data android:name="io.branch.sdk.TestMode" android:value="true" /> in Manifest instead. Added support to specify deep link path to Activity.

- v1.8.3: Fix for SMV issue caused by resource leak. Changes to add link parameters to intent for auto deep linked Activities.

- v1.8.2: Fix issue test and live keys are not set properly with auto session management when not using BranchApp.

- v1.8.1: Removing unnecessary reading of URI scheme. URI Scheme is read only when running in debug mode.

- v1.8.0: Adding new auto deep linking feature.

- v1.7.2: Fixed bug with handling Activity intent in auto session management.

- v1.7.1: Fixed bug with getting  Google Ads ID.

- v1.7.0: Adding an easy way to share custom deep links with social media and other applications. Provides a customisable chooser dialog for selecting applications.

- v1.6.2: Removed the BranchException thrown by SDK method. Added more logs to notify errors.

- v1.6.1: Fixed crashing issue when used with API-level below 14.

- v1.6.O: Improved thread handling and request processing mechanism. Fixed few bugs related with session management in auto mode. Also added fixes for handling network down condition properly.

- v1.5.11: Fix for a handling pending open request in queue while there is no valid identity_id.

- v1.5.10: Fix for a possible memory leak with touch-debugging feature.

- v1.5.9: Enhanced debugger triggering with the new session management. Also, fixed a bug in the new session management when the app already has a class extending from BranchApp.

- v1.5.8: Fix automated session management. Changes added to block multiple Activity life cycle listeners getting registered.

- v1.5.7: Added automated session management. Getting rid of session handling with each Activity's life cycle methods.

- v1.5.6: Add limit to queue retrieval to prevent legacy stack overflow ghosts.

- v1.5.5: Fix null server request tag bug.

- v1.5.4: Fix concurrent modification bug in ServerRequestQueue. Some code was added where there was rare possibility of modifying the ServerRequest body at the same time we were iterating through it.

- v1.5.3: Simplified branch_key setup by directly specifying it in Manifest.xml

- v1.5.2: Added retry count to all queries + a little better handling of retries

- v1.5.1: Added Javadocs for easy explanation of all methods

- v1.5.0: We have deprecated the use of `bnc_app_key` and are now using `branch_key`, which can be obtained in the settings page of your Dashboard. The replacement in the SDK should happen in the manifest and strings.xml (see README for details), as well as in `public static Branch getInstance(Context context, String branchKey)` if necessary.

- v1.4.5: Better handling of intent data for state transitions from Facebook's AppLinks

- v1.4.4: Fixed potential issue where update state was improperly set if no isReferrable specified

- v1.4.3: Added new update state to differentiate between update and open

- v1.4.2.2: Bullet proof prevention of duplicate callClose (reported StackOverflow error)

- v1.4.2.1: Catch OOM during parsing public dir

- v1.4.2: Added Unit tests

- v1.4.1: Fixed synchronization issue in persistence queue

- v1.4.0: Exposed duration in getShortUrl for tuning link click match duration

- v1.3.9: Added API Key to GET

- v1.3.8: Check memory when getting URI Scheme

- v1.3.7: Added app listing

- v1.3.6: Fix pre Honeycomb (3.0) bug

- v1.3.5: Added advertising id to init params (optional)

- v1.3.4: Added optional advertising id to install params

- v1.3.3: Fixed issue with null tags

- v1.3.2: Added API's to getShortURL synchronously

- v1.3.1: Enforce setting app key before any API call; Provided ability to turn off smart session

- v1.3.0: Added setDebug call to enable logging and use a random hardware ID (helpful for referral testings). Also, cacheing of links to save on network requests

- v1.2.9: Moved app key to strings.xml; Added constants for OG tags and redirect URLs

- v1.2.8: Fixed close issue due to rotation

- v1.2.7: Check if URI is hierarchical

- v1.2.6: Handle not init-ed case

- v1.2.5: Proper debug connection

- v1.2.4: Fixed rare race condition

- v1.2.3: Added BranchError to callbacks

- v1.2.2: Added Branch remote debug feature

- v1.2.1: Proper network callbacks; Added query limit

- v1.2.0: Cleanup semaphore issue

- v1.1.9: Fixed request before init issue

- v1.1.8: Added link alias