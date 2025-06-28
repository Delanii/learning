# General Postman usage

## Workspaces

- workspaces are for projects
- global variables are available in the entire workspace

## Collections

- collections are for individual APIs. Potentially, a project might have multiple APIs (like one API for each service)
- all API requests in a collection can have common authorization or variables

## Environments

- an environment is a set of variables we can use in collections
- each variable has an initial ad current value. In each postman run, the variable starts with it's initial value. Any changes to the variable are copied in the current value.

## Variables

- a variable referenced in requests as `{{variableName}}`; variables can be used in the same way in the request body
- variables have the following scopes:

  + **global**: available to the entire workspace
  + **collection**: available to all requests in the collection
  + **environment**: available to all requests when selected
  + **data**: loaded from a data file
  + **local**: available to a specific request
  
- scope precedence and variable shadowing: If there are two variables in use with the same name, the variable with the narrowest scope is used. The local variables have the biggest priority, while global variables the lowest.

## Scripts

- pre-request and post-request scripts use a node.js sandbox; so the syntax is javascript-y
- all assertions are members or methods of the `pm` object

### Printing

- `console.log("String readable in the Postman console.");`

### Tests and assertions

accessed with:

`pm.test("test name", function)`: `function` contains the actual test, while the test name is a identifier to look for in the test results or in the console output.

for example:

```js
pm.test("Check success status", function(){
  pm.response.to.have.status(200);
  pm.expect(pm.response.json()).to.have.property("Msg");
});
```

`pm.expect()` seems to be a better choice for assertions now.

- Postman assertions are using "chai" syntax

#### Validate JSON response against schema

```js
const schema = {
  "type": "array",
  "items": [
    {
      "type": "object",
      "properties": {
        "book_name": {
          "type": "string"
        },
        "isbn": {
          "type": "string"
        },
        "aisle": {
          "type": "string"
        },
        "author": {
          "type": "string"
        }
      },
      "required": [
        "book_name",
        "isbn",
        "aisle",
        "author"
      ]
    }
  ]
};

pm.test("Validate response structure", function() {
  pm.response.to.have.jsonSchema(schema);
});
```

### Accessing variables

- Postman built-in variables:

  `pm.variables.replaceIn('{{$randomInt}}')` -- all of this has to be in the script

- global variables:

  `pm.global.get("globalVarName");`

- collection variables:

  `pm.collectionVariables.get("variableName");`
  
#### Updating variables

- for example:

  `pm.collectionVariables.set("variableName", "new value");`
