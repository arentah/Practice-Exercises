/*Implement a function that adds two numbers together and returns their sum in binary.
The conversion can be done before, or after the addition.
The binary number returned should be a string*/
function addBinary(a, b) {
    return ((a + b) >>> 0).toString(2); //(a+b).toString(2);
}

/*In mathematics, the factorial of a non-negative integer n, denoted by n!, is the product
of all positive integers less than or equal to n. For example: 5! = 5 * 4 * 3 * 2 * 1 = 120.
By convention the value of 0! is 1. Write a function to calculate factorial for a given input.
If input is below 0 or above 12 throw an exception of type ArgumentOutOfRangeException (C#)
or IllegalArgumentException (Java) or RangeException (PHP) or throw a RangeError (JavaScript).*/
function factorial(n) {
    let fac = 0;
    if (n > 12 || n < 0)
        throw new RangeError(["The number is larger than 12 or less than zero..."]);
    else if (n === 0)
        return fac = 1;
    else {
        fac = 1;
        for (let i = n; i > 0; i--) {
            fac *= i;
        }
    }
    return fac;
    // if(n < 0 || n > 12) throw new RangeError('Ошибка');
    // return n ? n * factorial(n-1) : 1;
}

/*For building the encrypted string: Take every 2nd char from the string, then the other chars,
that are not every 2nd char, and concat them as new String. Do this n times!*/
function encrypt(text, n) {
    if (n === 0 || text === null || text === "" || n < 0) {
        return text;
    }
    let str = "";
    for (let i = 0; i < text.length; i++) {
        if (i % 2 === 1) {
            str += text[i];
        }
    }
    for (let i = 0; i < text.length; i++) {
        if (i % 2 === 0) {
            str += text[i];
        }
    }
    return encrypt(str, n - 1);
}

function decrypt(encryptedText, n) {
    if (n === 0 || encryptedText === null || encryptedText === "" || n < 0 || encryptedText.length === 1) {
        return encryptedText;
    }
    let str = "";
    for (let i = Math.floor(encryptedText.length / 2), j = 0; i < encryptedText.length && j < Math.floor(encryptedText.length / 2); i++, j++) {
        str += encryptedText[i];
        str += encryptedText[j];
        if (i % 2 === 1 && i === encryptedText.length - 2) {
            str += encryptedText[i + 1];
        }
    }
    return decrypt(str, n - 1);
}

/*function encrypt(text, n) {
  for (let i = 0; i < n; i++) {
    text = text && text.replace(/.(.|$)/g, '$1') + text.replace(/(.)./g, '$1')
  }
  return text
}

function decrypt(text, n) {
  let l = text && text.length / 2 | 0
  for (let i = 0; i < n; i++) {
    text = text.slice(l).replace(/./g, (_, i) => _ + (i < l ? text[i] : ''))
  }
  return text
}*/

/*function encrypt(text, n) {
  console.log(text, n);
  if (!text || n <= 0) return text;
  while (n--) {
    let ans = '';
    for (let i = 1; i < text.length; i += 2) {
      ans += text[i];
    }
    for (let i = 0; i < text.length; i += 2) {
      ans += text[i];
    }
    text = ans;
  }
  return text;
}

function decrypt(encryptedText, n) {
  if (!encryptedText || n <= 0) return encryptedText;
  const ans = new Array(encryptedText.length);
  while (n--) {
    let j = 0;
    for (let i = 1; i < ans.length; i += 2) {
      ans[i] = encryptedText[j++];
    }
    for (let i = 0; i < ans.length; i += 2) {
      ans[i] = encryptedText[j++];
    }
    encryptedText = ans.join('');
  }
  return encryptedText;
}*/

/*function encrypt(text, n) {
  if (!text || !text.length || n <= 0)
  {
    return text;
  }

  var res = "";
  var oth = "";

  for (var i = 0; i < text.length; ++i)
  {
    if (i % 2 == 0)
    {
      oth += text[i];
    }
    else
    {
      res += text[i];
    }
  }

  return encrypt(res + oth, --n);
}

function decrypt(encryptedText, n) {
  if (!encryptedText || !encryptedText.length || n <= 0)
  {
    return encryptedText;
  }

  var first = encryptedText.slice(0, encryptedText.length / 2);
  var second = encryptedText.slice(encryptedText.length / 2);

  var res = "";
  var i = 0;
  var j = 0;

  while (res.length < encryptedText.length)
  {
    if (res.length % 2 == 0)
    {
      res += second[i];
      i++;
    }
    else
    {
      res += first[j];
      j++;
    }
  }

  return decrypt(res, --n);
}*/

/*Your task is to write function findSum.
Upto and including n, this function will return the sum of all multiples of 3 and 5.*/
function findSum(n) {
    let arr = [];
    for (let i = 3, j = 5; i <= n; i += 3, j += 5) {
        if(j <= n)
            arr.push(j);
        if(arr.find(function(num){return num === i}) === undefined)
            arr.push(i);
        else{}
    }
    return arr.reduce(function(acc,val){
        return acc+val;
    },0);
}

/*function findSum(n) {
  let result = 0;
  for (let i = 0; i <= n; i += 1) {
    if (i % 3 ===0 || i % 5 === 0) result += i
  }
  return result
}*/

/*const sumMultiples = (m, n) => {
  let x = n / m | 0;
  return m * x * (x + 1) / 2;
};

const findSum = n =>
  sumMultiples(3, n) + sumMultiples(5, n) - sumMultiples(15, n);*/

/*const f = (k, n) => k * ~~(n/k) * ~~(n/k + 1) / 2;
const findSum = n => f(3, n) + f(5, n) - f(15, n);*/

/*function findSum(n) {
  var res = 0;
  for(var i = 0; i <= n; i++) {
    if(i % 3 === 0 || i % 5 === 0) {
      res += i;
    }
  }
  return res;
}*/
