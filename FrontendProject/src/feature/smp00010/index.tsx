import React, {useState, useEffect} from "react";
import {useReactTable, getCoreRowModel, flexRender} from "@tanstack/react-table";
import * as constant from "../../constant";
import * as restFacade from "../../api/restFacade";
import * as definitions from "./definitions";

const screenId: string = "smp00010";

export const Biz = () => {

  const [jnwmbsEntities, setJnwmbsEntities] = 
    useState<definitions.listJnwmbsResponse[]>([]);

  const requestParameters: definitions.listJnwmbsRequest = {
    bsbscd: '1111'
  };

  const jnwmbsTable = useReactTable({
    data: jnwmbsEntities,
    columns: definitions.jnwmbsColumns,
    getCoreRowModel: getCoreRowModel()
  });

  useEffect(() => {
    restFacade.interpretPostWithGet(
      constant.accessTo.businessScreenApi(screenId, "base", "onLoad"),
      requestParameters,
      setJnwmbsEntities);
    }, []
  );

  return (
    <table>
      <thead>
        {
          jnwmbsTable.getHeaderGroups().map(headers => (
            <tr key = { headers.id }>
              { headers.headers.map(header => (
                  <th key = { header.id }>
                    {
                      header.isPlaceholder
                        ? null:
                          flexRender(
                            header.column.columnDef.header,
                            header.getContext()
                          )
                    }
                  </th>
                ))
              }
            </tr>
          ))
        }
      </thead>
      <tbody>
        {
          jnwmbsTable.getRowModel().rows.map(row => (
            <tr key = { row.id }>
              {
                row.getVisibleCells().map(cell => (
                  <td key = { cell.id }>
                    { 
                      flexRender(
                        cell.column.columnDef.cell,
                        cell.getContext()
                      )
                    }
                  </td>
                ))
              }
            </tr>
          ))
        }
      </tbody>
    </table>
  );
};