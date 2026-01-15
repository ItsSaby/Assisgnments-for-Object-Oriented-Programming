-- DESCRIPTION --
This is a simple console-based social media project written in Java.  
Users can create profiles, write posts, add stories, and view all content inside the social network.

-- How to run the project --
1. Open the project in any Java IDE (IntelliJ IDEA, Eclipse, or VS Code).
2. Run the `Main.java` file.
3. Use the console menu to interact with the program.


-- Overview --
A new abstract class named `SocialEntity` has been created.
This class serves as the foundational type for various content forms.

-- Inheritance --
- The `Post` class is derived from `SocialEntity`.
- The `Story` class also inherits from `SocialEntity`.

-- Polymorphism --
Both posts and stories are stored as instances of `SocialEntity`.
The `show()` method features distinct implementations for each type, allowing it to be executed dynamically at runtime.

-- Encapsulation--
All attributes within the classes are designated as private.
Data access is facilitated through specific methods.

-- Data Management --
User information is housed within the `SocialNetwork` class.
"Posts and stories are organized under the `Profile` class."

-- User Search --
Users can be located by their usernames.

-- User Sorting --
Users can be arranged based on their usernames.

-- Overridden Methods --
The following methods have been overridden: 
- `toString()`
- `equals()`
- `hashCode()`

