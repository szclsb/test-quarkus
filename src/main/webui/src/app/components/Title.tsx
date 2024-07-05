import React from "react";
import {Typography} from "@mui/material";

export default function Title(props: {text: string}) {
    return (<Typography textAlign='center' variant="h5" gutterBottom>
        {props.text}
    </Typography>)
}
