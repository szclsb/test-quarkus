import React from "react";
import {Box, Stack} from "@mui/material";

export function Header(props: {info?: string}) {
    return (<Stack>
        <Box display="flex"
             justifyContent="space-between"
             alignItems="center">
            <Stack>
                <div>{props.info}</div>
            </Stack>
        </Box>
    </Stack>);
}
