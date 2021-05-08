const xhr = new XMLHttpRequest();

function request(method, url, obj = null, callback) {
    xhr.open(method, url);
    xhr.onload = () => {
        if (xhr.status != 200) callback(new Error(`${xhr.status} - ${xhr.statusText}`));
        else callback(null, xhr.response);
    }

    xhr.onerror = () => callback(new Error(`${xhr.status} - ${xhr.statusText}`));
    xhr.send(JSON.stringify(obj));
}

function sendRequest(method, url, obj) {
    return new Promise((resolve, reject) => {
        console.warn("Promise " + url);
        request(method, `http://localhost:8080/${url}`, obj, (err, data) => {
            if (err) {
                reject(err)
            } else {
                resolve(data)
            }
        })
    })
}