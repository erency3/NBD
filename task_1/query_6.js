printjson(
db.people.insert(
{
  sex: 'Male',
  first_name: 'Eren',
  last_name: 'Yalcin',
  job: 'BI developer',
  email: 'ereny@gmail.com',
  location: {
    city: 'Warsaw',
    address: { streetname: 'Choldna', streetnumber: '18' }
  },
  description: 'blabla',
  height: '175',
  weight: '72',
  birth_date: '1985-02-22T11:51:38Z',
  nationality: 'Turkey',
  credit: [
   
    {
      type: 'visa-electron',
      number: '1231331312313',
      currency: 'PLN',
      balance: '2000.25'
    }
      
  ]
})
);
