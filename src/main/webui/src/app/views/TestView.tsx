import {useEffect, useState} from "react";
import {List, ListItem} from "@mui/material";
import Title from "app/components/Title";
import {TestApi} from "gen/apis";
import {TestReadDto, TestWriteDto} from "gen/models";

function TestView() {
    const [tests, setTests] = useState<TestReadDto[]>([]);
    const testClient = new TestApi();

    useEffect(() => {
        testClient.listAllTests()
            .then(r => setTests(r ?? []))
            .catch(err => {
                console.warn(err);
            });
    }, [])

    return (
        <List  subheader={<Title text="Tests"/>}>
            {tests.map((test, i) => <ListItem key={i} sx={{
                border: '0.1em solid black',
                padding: '0.5em',
                margin: '0.5em',
                borderRadius: '1em'
            }}>
                <p>{test.text}</p>
            </ListItem>)}
        </List>
    );
}

export default TestView;
