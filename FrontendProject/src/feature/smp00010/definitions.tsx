export const jnwmbsColumns = [
    {
        accessorKey: "bsbscd",
        header: "部署コード"
      },
      {
        accessorKey: "bsckcd",
        header: "地区"
      },
      {
        accessorKey: "bsbsrn",
        header: "部署略称(漢字)"
      },
      {
        accessorKey: "bsbskn",
        header: "部署名称(カナ)"
      },
      {
        accessorKey: "bsbsjn",
        header: "部署名称(漢字)"
      },
      {
        accessorKey: "bscdkb",
        header: "カレンダー区分"
      }
];

export type listJnwmbsRequest = {
    bsbscd: string
};    

export type listJnwmbsResponse = {
    bsbscd: string,
    bsckcd: string,
    bsbsrn: string,
    bsbskn: string,
    bsbsjn: string,
    bscdkb: number
};