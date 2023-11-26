


// mật khẩu cũ
const ipnElement = document.querySelector('#ip_password')
const btnElement = document.querySelector('#btnPassword')

// step 2
btnElement.addEventListener('click', function() {
  // step 3
  const currentType = ipnElement.getAttribute('type')
  // step 4
  ipnElement.setAttribute(
    'type',
    currentType === 'password' ? 'text' : 'password'
  )
})


// nhập mật khẩu
const ipnElementRe1 = document.querySelector('#ip_repassword1')
const btnElementRe1 = document.querySelector('#btnrePassword1')

// step 2
btnElementRe1.addEventListener('click', function() {
  // step 3
  const currentType = ipnElementRe1.getAttribute('type')
  // step 4
  ipnElementRe1.setAttribute(
    'type',
    currentType === 'password' ? 'text' : 'password'
  )
})



// nhập lại  mật khẩu
const ipnElementRe2 = document.querySelector('#ip_repassword2')
const btnElementRe2 = document.querySelector('#btnrePassword2')

// step 2
btnElementRe2.addEventListener('click', function() {
  // step 3
  const currentType = ipnElementRe2.getAttribute('type')
  // step 4
  ipnElementRe2.setAttribute(
    'type',
    currentType === 'password' ? 'text' : 'password'
  )
})