async function getPhrase(userId, api_key, nickName, formattedDate) {

    let value = ''
    console.log(userId);
    const reg = /[\{\}\[\]\/"?.,;:|\)*~`!^\_+<>@\#$%&\\\=\(\'\"]/gi;

    const config = {
        headers: {
            Authorization: api_key.replace(reg, ''),
            'Content-Type': 'application/json',
        },
    }

    const config1 = {
        headers: {
            'Content-Type': 'application/json'
        },
    }

    await axios
        .get(`/phrases/${ userId.replace(reg, '') }?date=${ formattedDate }`, config1)
        .then((response) => {
            let resultDiv = document.getElementById('myModal');
            value = response.data.phrase;
            // document.getElementById('phrase-ai-1').remove();
            myForm =  document.getElementById('phrase-ai').innerHTML = `<div id"phrase-ai-1"> AI 주접 : ${ value }</div>`;
        }).catch((e) => {
            console.log(e);
        })

    if(!value) {

        const messages = [
            {"role": "system", "content": `당신은 느끼하며 반말을 합니다. ${nickName}을 반드시 이용해서 주접을 떠세요`},
            {"role": "system", "content": "한 문장으로 대답하세요"}
        ]

        const data = {
            model: 'gpt-3.5-turbo',
            temperature: 0.5,
            n: 1,
            messages: messages,
        }

        await axios
            .post('https://api.openai.com/v1/chat/completions', data, config)
            .then((response) => {
                let resultDiv = document.getElementById('myModal');
                console.log(response.data.choices[0].message.content);
                const phrase = response.data.choices[0].message.content
                resultDiv.getElementsByClassName('modal-body').innerHTML = ''
                response.data.choices.forEach((choice, index) => {
                    resultDiv.innerHTML += `<div>${choice.message.content
                        .split('\n')
                        .join('<br/>')}</div>`
                })

                const data = {
                    phrase : phrase,
                    date : formattedDate
                }

                axios
                    .post(`/phrases/${ userId.replace(reg, '') }`, data, config1)
                    .then((res) => {
                        console.log(res);
                    })
                    .catch((err) => {
                        console.log(err);
                    })
            })
            .catch((error) => {
                console.error(error)
            })
    }
}