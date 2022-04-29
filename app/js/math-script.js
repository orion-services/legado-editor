function convert() {
    //
    //  Get the TeX input
    //
    var input = document.getElementById("input").value.trim();
    //
    //  Disable the display and render buttons until MathJax is done
    //
    saveMath(input);
    console.warn(input);
    
    
    var display = document.getElementById("display");
    var button = document.getElementById("render");
    button.disabled = display.disabled = true;
    //
    //  Clear the old output
    //
    output = document.getElementById('output');
    output.innerHTML = '';
    //
    //  Reset the tex labels (and automatic equation numbers, though there aren't any here).
    //  Get the conversion options (metrics and display settings)
    //  Convert the input to CommonHTML output and use a promise to wait for it to be ready
    //    (in case an extension needs to be loaded dynamically).
    //
    MathJax.texReset();
    var options = MathJax.getMetricsFor(output);
    options.display = display.checked;
    MathJax.tex2chtmlPromise(input, options).then(function (node) {
      //
      //  The promise returns the typeset node, which we add to the output
      //  Then update the document to include the adjusted CSS for the
      //    content of the new equation.
      //
      output.appendChild(node);
      MathJax.startup.document.clear();
      MathJax.startup.document.updateDocument();
    }).catch(function (err) {
      //
      //  If there was an error, put the message into the output instead
      //
      output.appendChild(document.createElement('pre')).appendChild(document.createTextNode(err.message));
    }).then(function () {
      //
      //  Error or not, re-enable the display and render buttons
      //
      button.disabled = display.disabled = false;
    });
  }

  async function saveMath(input){

    var details = {
      textCode:input,
      id:1
    };
    
    var formBody = [];
    for (var property in details) {
      var encodedKey = encodeURIComponent(property);
      var encodedValue = encodeURIComponent(details[property]);
      formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const hashh = urlParams.get('hash');
    console.warn(formBody)

      const getData = async () => {
        const response = await fetch('http://localhost:8080/editor/api/v1/incrementCode/'+hashh, {
          method: 'POST',
          mode: 'cors',
          headers: {
            'content-type': 'application/x-www-form-urlencoded',
            'accept': '*/*',
            'connection':'keep-alive',
            'X-Requested-With': 'XMLHttpRequest'
          },
          body: formBody,
        });
        console.info("Response:", response)
      };
    getData()
  }



async function loadMath(input) {

const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const hashh = urlParams.get('hash');
console.log(hashh);

  function axiosLoad() {
    // create a promise for the axios request
    const promise = axios.get("http://localhost:8080/editor/api/v1/loadCode/" + hashh)
    // using .then, create a new promise which extracts the data
    const dataPromise = promise.then((response) => response.data)
    // return it
    return dataPromise
}

// now we can use that data from the outside!

axiosLoad()
    .then(data => {
      if ('localStorage' in window && data.textCode) {
        console.log(input);  
      }
    })
    .catch(err => console.log(err))



};