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

export default function MyApp() {
  return (
    <div>
      <h1>Welcome to my page</h1>
      <MyButton />
      <Profile />
    </div>
  );
}
