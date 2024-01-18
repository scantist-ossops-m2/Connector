/*
 *  Copyright (c) 2022 Microsoft Corporation
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       Microsoft Corporation - initial API and implementation
 *       Mercedes-Benz Tech Innovation GmbH - connector id removal
 *
 */

package org.eclipse.edc.connector.store.sql.transferprocess.store.schema.postgres;

import org.eclipse.edc.connector.store.sql.transferprocess.store.schema.TransferProcessStoreStatements;
import org.eclipse.edc.connector.transfer.spi.types.DataRequest;
import org.eclipse.edc.sql.translation.JsonFieldTranslator;
import org.eclipse.edc.sql.translation.TranslationMapping;

/**
 * Maps fields of a {@link DataRequest} onto the corresponding
 * SQL schema (= column names) enabling access through Postgres JSON operators
 */
class DataRequestMapping extends TranslationMapping {

    private static final String FIELD_ID = "id";
    private static final String FIELD_PROCESS_ID = "processId";
    private static final String FIELD_CONNECTOR_ADDRESS = "connectorAddress";
    private static final String FIELD_PROTOCOL = "protocol";
    private static final String FIELD_ASSET_ID = "assetId";
    private static final String FIELD_CONTRACT_ID = "contractId";
    private static final String FIELD_DATA_DESTINATION = "dataDestination";
    private static final String FIELD_TRANSFER_PROCESS_ID = "transferProcessId";

    DataRequestMapping(TransferProcessStoreStatements statements) {
        add(FIELD_ID, statements.getDataRequestIdColumn());
        add(FIELD_PROCESS_ID, statements.getProcessIdColumn());
        add(FIELD_CONNECTOR_ADDRESS, statements.getConnectorAddressColumn());
        add(FIELD_PROTOCOL, statements.getProtocolColumn());
        add(FIELD_ASSET_ID, statements.getAssetIdColumn());
        add(FIELD_CONTRACT_ID, statements.getContractIdColumn());
        add(FIELD_DATA_DESTINATION, new JsonFieldTranslator(statements.getDataDestinationColumn()));
        add(FIELD_TRANSFER_PROCESS_ID, statements.getTransferProcessIdFkColumn());
    }
}
