# Keep Navigation Component classes
-keep class androidx.navigation.** { *; }

# Keep Material Components
-keep class com.google.android.material.** { *; }

# Keep your app classes
-keep class com.moietplusultra.** { *; }

# Keep Kotlin metadata
-keep class kotlin.Metadata { *; }

# Prevent crashes on reflection
-keepattributes *Annotation*
-keepattributes Signature
-keepattributes InnerClasses
-keepattributes EnclosingMethod