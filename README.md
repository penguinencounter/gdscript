# GdScript

## Work queue
### Top priority
- Match case (dictionary)
- Dictionaries
- Lambdas
- Signals
- Inner class
- Parent method call fe.: ._init()
- Annotation parameters
- Formatter into non-disrupt state

### Middle Priority
- Full feature Formatter
- Check Parameters in function call
- expr type match
- Resource exists
- Double enter -> force dedent
- Create getter/setter via Alt+Insert
- Multi-line string bugs
- Don't auto-complete private functions/fields (leading underscore) -> allow it based on settings
- Run configuration - line marker
- Line marker (signals, ...)
- Enum checks
- Flow templates

### Low Priority
- Rename file -> rename also class_name
- Linkable Documentation
- type of var binding in match pattern
- solo string expects endStmt
- Debug - does it Godot even allow? ...

## List of features
### Auto-completion
- Inheritance & ClassName
- Annotations
- func overrides
- Resources (`$Path/Node` && `$"%Name"`)

### Documentation (Ctrl+Q)
- Currently only simplified plain-text
- ❌ Links and visualization like Java doc

### Other
- Inlay hints  
 ![](./screens/inlay.png)
- Param hints (Ctrl+P)  
![](./screens/param-hint.png)
- Run configuration - starts the game from Godot exe  
![](./screens/run-config.png)

### Formatter
- Very simplified version - requires major work  
- ❌ Optional semicolons (add/remove based on settings)

## Actions
### Quick fixes
#### Alt+Enter
- add/change return Type
- remove annotation
- change class_name to match filename
