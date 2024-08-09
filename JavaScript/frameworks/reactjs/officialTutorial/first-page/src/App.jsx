import { useState } from 'react';

const user = {
  name: 'Hedy Lamarr',
  imageUrl: 'https://i.imgur.com/yXOvdOSs.jpg',
  imageSize: 90,
};

function MyButton() {
  return (
    <button>
      I'm a button.
    </button>
  );
}

function Profile() {
  return (
    <>
    <h2>{user.name}</h2>
      <img
        className="avatar"
        src={user.imageUrl}
        alt={'Photo of ' + user.name}
        syle={{
          width: user.imageSize,
          height: user.imageSize
        }}
      />
    </>
  )
}

const products = [
  { title: 'Cabbage', isFruit: false, id: 1 },
  { title: 'Garlic', isFruit: false, id: 2 },
  { title: 'Apple', isFruit: true, id: 3 },
];

function ShoppingList() {
  const listItems = products.map(product =>
    <li
      key={product.id}
      style={{
        color: product.isFruit ? 'magenta' : 'darkgreen'
      }}
    >
    {product.title}
    </li>
  );

  return (
    <ul>
      {listItems}
    </ul>
  );
}

function SeparateButtonCounter() {

  const [separateCount, setSeparateCount] = useState(0);

  function separateHandleClick() {
    setSeparateCount(separateCount + 1);
  }

  return (
    <button onClick={separateHandleClick}>
      You clicked {separateCount} times.
    </button>
  )
}

function SharedButtonCounter({ sharedCount, onClick }) {
  return (
    <button
      onClick={onClick}
    >
      Clicked {sharedCount} times
    </button>
  )
}

export default function MyApp() {

  const [sharedCount, setSharedCount] = useState(0);

  function handleSharedClick() {
    setSharedCount(sharedCount + 1);
  }

  return (
    <div>
      <h1>Welcome to my page</h1>
        <MyButton />
        <Profile />
        <ShoppingList />

        <h2>Counters</h2>
        <h3>Separate counters</h3>
          <SeparateButtonCounter />
          <SeparateButtonCounter />

        <h3>Shared counters</h3>
          <SharedButtonCounter sharedCount={sharedCount} onClick={handleSharedClick} />
          <SharedButtonCounter sharedCount={sharedCount} onClick={handleSharedClick} />
    </div>
  );
}
